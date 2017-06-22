package haru.worker.application.impl

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import haru.worker.domain.model.plugin.TaskProcessorPlugin
import haru.worker.domain.model.plugin.TaskProcessorPluginRegistry
import haru.worker.domain.model.processor.TaskProcessingLogger
import haru.worker.domain.model.processor.TaskProcessingParams
import haru.worker.domain.model.processor.TaskProcessor
import haru.worker.domain.model.task.Task
import haru.worker.domain.model.task.TaskId
import haru.worker.domain.model.task.TaskResult
import kotlinx.coroutines.experimental.delay
import org.junit.After
import org.junit.Before
import org.junit.Test

class TaskProcessingServiceImplTest {

  val taskProcessor = object : TaskProcessor {
    suspend override fun process(params: TaskProcessingParams, logger: TaskProcessingLogger): TaskResult {
      delay(500)
      return mock()
    }
  }

  val taskProcessorPlugin = mock<TaskProcessorPlugin> {
    on { createProcessor(any()) } doReturn taskProcessor
  }

  val pluginRegistry = mock<TaskProcessorPluginRegistry> {
    on { findById(any()) } doReturn taskProcessorPlugin
  }

  val sut = TaskProcessingServiceImpl(pluginRegistry)

  @Before
  fun setUp() {
    sut.startAsync().awaitRunning()
  }

  @After
  fun tearDown() {
    sut.stopAsync().awaitTerminated()
  }

  @Test
  fun processTask() {
    val task = mock<Task> {
      on { id } doReturn TaskId("test")
      on { params } doReturn mock<TaskProcessingParams>()
      on { logger } doReturn mock<TaskProcessingLogger>()
    }

    sut.submit(task)

    Thread.sleep(1000)

    verify(pluginRegistry).findById(any())
    verify(taskProcessorPlugin).createProcessor(any())
    verify(task).start()
    verify(task).complete(any())
  }

}