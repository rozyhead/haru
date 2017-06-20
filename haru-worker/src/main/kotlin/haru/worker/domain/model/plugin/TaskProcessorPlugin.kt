package haru.worker.domain.model.plugin

import haru.worker.domain.model.processor.TaskProcessor

interface TaskProcessorPlugin {

  val id: TaskProcessorPluginId

  fun createProcessor(config: TaskProcessorConfig): TaskProcessor

}