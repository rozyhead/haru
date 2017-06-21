package haru.worker.domain.model.task

import haru.worker.domain.model.plugin.TaskProcessorConfig
import haru.worker.domain.model.plugin.TaskProcessorPluginId
import haru.worker.domain.model.processor.TaskProcessingParams
import haru.worker.domain.model.processor.TaskProcessingLogger

interface Task {

  val id: TaskId

  val pluginId: TaskProcessorPluginId

  val config: TaskProcessorConfig

  val params: TaskProcessingParams

  val logger: TaskProcessingLogger

  fun start()

  fun complete(result: TaskResult)

  fun completeExceptionally(thrown: Throwable)

}