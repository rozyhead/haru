package haru.worker.domain.model.processor

import haru.worker.domain.model.task.TaskResult

interface TaskProcessor {

  suspend fun process(params: TaskProcessingParams, logger: TaskProcessingLogger): TaskResult

}