package haru.worker.application

import haru.worker.domain.model.task.Task

interface TaskProcessingService {

  fun submit(task: Task)

}