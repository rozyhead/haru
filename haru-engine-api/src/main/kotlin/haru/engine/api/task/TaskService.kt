package haru.engine.api.task

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * @author takeshi
 */
interface TaskService {

  @RequestMapping(
      value = "/api/v1/tasks",
      method = arrayOf(RequestMethod.GET),
      produces = arrayOf("application/json")
  )
  fun getTasks(): List<Task>
}