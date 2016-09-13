package haru.engine.port.adapter.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author takeshi
 */
@RestController
open class TaskController {

  data class TaskJson(val name: String)

  @GetMapping("/api/v1/tasks")
  fun tasks(): List<TaskJson> {
    return listOf(TaskJson("dummy"))
  }

}
