package haru.engine.port.adapter.web

import haru.engine.api.task.Task
import haru.engine.api.task.TaskService
import org.springframework.web.bind.annotation.RestController

/**
 * @author takeshi
 */
@RestController
open class TaskController : TaskService {

  override fun getTasks(): List<Task> {
    return listOf(Task("dummy"))
  }

}
