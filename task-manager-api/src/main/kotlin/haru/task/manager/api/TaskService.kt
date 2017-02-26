package haru.task.manager.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

interface TaskService {

  @RequestMapping(
      value = "/api/v1/tasks",
      method = arrayOf(RequestMethod.GET),
      produces = arrayOf("application/json")
  )
  fun getTasks(): List<Task>
}