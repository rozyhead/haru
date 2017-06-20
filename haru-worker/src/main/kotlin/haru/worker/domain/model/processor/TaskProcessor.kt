package haru.worker.domain.model.processor

import haru.worker.domain.model.task.TaskResult

interface TaskProcessor {

  @Throws(TaskProcessingException::class)
  operator fun invoke(arguments: TaskProcessingArguments, logger: TaskProcessingLogger): TaskResult

}