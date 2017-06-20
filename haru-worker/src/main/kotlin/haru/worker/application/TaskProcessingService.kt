package haru.worker.application

import haru.worker.domain.model.task.Task
import haru.worker.domain.model.task.TaskResult

interface TaskProcessingService {

  fun processTask(task: Task): TaskResult

}