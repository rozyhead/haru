package haru.worker.application.interactor

import haru.worker.application.TaskProcessingService
import haru.worker.domain.model.plugin.TaskProcessorPluginRegistry
import haru.worker.domain.model.task.Task
import java.util.concurrent.ExecutorService

class TaskProcessingServiceInteractor(
    val pluginRegistry: TaskProcessorPluginRegistry,
    val executorService: ExecutorService
) : TaskProcessingService {

  override fun submit(task: Task) {
    val plugin = pluginRegistry.findById(task.pluginId)
    val processor = plugin.createProcessor(task.config)

    executorService.submit {
      task.start()
      try {
        val result = processor(task.arguments, task.logger)
        task.complete(result)
      } catch (e: Exception) {
        task.completeExceptionally(e)
      }
    }
  }

}