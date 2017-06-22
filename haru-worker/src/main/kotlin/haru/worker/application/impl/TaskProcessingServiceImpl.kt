package haru.worker.application.impl

import com.google.common.util.concurrent.AbstractIdleService
import haru.worker.application.TaskProcessingService
import haru.worker.domain.model.plugin.TaskProcessorPluginRegistry
import haru.worker.domain.model.task.Task
import haru.worker.domain.model.task.TaskId
import kotlinx.coroutines.experimental.*
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class TaskProcessingServiceImpl(
    val pluginRegistry: TaskProcessorPluginRegistry,
    val dispatcher: CoroutineDispatcher = CommonPool,
    val shutdownTimeout: Long = 120_000,
    val shutdownTimeoutUnit: TimeUnit = TimeUnit.MILLISECONDS
) : AbstractIdleService(), TaskProcessingService {

  val logger = LoggerFactory.getLogger(this.javaClass)!!
  val singleThreadContext = newSingleThreadContext(this.javaClass.simpleName)
  val parentJob = Job()
  var jobs = mapOf<TaskId, Job>()

  override fun startUp() {}

  override fun shutDown() {
    runBlocking {
      if (jobs.isNotEmpty()) {
        logger.info("There are processing tasks, await for completion up to 60 seconds...")
        awaitAllTasksCompleted(shutdownTimeout, shutdownTimeoutUnit)
        if (jobs.isNotEmpty()) {
          logger.warn("Cancel processing tasks: {}", jobs.keys)
          awaitAllTasksCompleted(shutdownTimeout, shutdownTimeoutUnit)
          if (jobs.isNotEmpty()) {
            logger.warn("All processing tasks were already cancelled, but some tasks are not completed. Ignore non completed tasks: {}", jobs.keys)
          }
        }
      }
    }
  }

  override fun submit(task: Task) {
    check(isRunning)

    val plugin = pluginRegistry.findById(task.pluginId)
    val processor = plugin.createProcessor(task.config)

    val coroutineName = CoroutineName("task-${task.id.value}")
    val context = dispatcher + coroutineName + parentJob

    launch(context) {
      val job = context[Job]!!
      run(singleThreadContext) {
        jobs += (task.id to job)
      }

      task.start()
      try {
        val result = processor.process(task.params, task.logger)
        task.complete(result)
      } catch (e: Exception) {
        task.completeExceptionally(e)
      } finally {
        run(singleThreadContext) {
          jobs -= task.id
        }
      }
    }
  }

  override fun cancel(taskId: TaskId) {
    launch(singleThreadContext) {
      jobs[taskId]?.cancel()
    }
  }

  private suspend fun awaitAllTasksCompleted(timeout: Long, timeoutUnit: TimeUnit) {
    var count = 0
    val maxCount = timeoutUnit.toSeconds(timeout)
    while (jobs.isNotEmpty() && count < maxCount) {
      delay(1, TimeUnit.SECONDS)
      count++
    }
  }

}