package haru.worker.application.interactor

import haru.worker.application.TaskProcessingService
import haru.worker.domain.model.plugin.TaskProcessorPluginRegistry
import haru.worker.domain.model.task.Task
import haru.worker.domain.model.task.TaskResult

class TaskProcessingServiceInteractor(
    val pluginRegistry: TaskProcessorPluginRegistry
) : TaskProcessingService {

  override fun processTask(task: Task): TaskResult {
    val plugin = pluginRegistry.findById(task.pluginId)
    val processor = plugin.createProcessor(task.config)
    return processor(task.arguments, task.logger)
  }

}