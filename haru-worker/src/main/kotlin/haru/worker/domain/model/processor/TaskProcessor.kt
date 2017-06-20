package haru.worker.domain.model.processor

interface TaskProcessor {

  @Throws(TaskProcessingException::class)
  operator fun invoke(arguments: TaskProcessingArguments, logger: TaskProcessingLogger): haru.worker.domain.model.task.TaskResult

}