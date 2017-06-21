package haru.worker.application

import com.google.common.util.concurrent.Service
import haru.worker.domain.model.task.Task
import haru.worker.domain.model.task.TaskId

interface TaskProcessingService : Service {

  fun submit(task: Task)

  fun cancel(taskId: TaskId)

}