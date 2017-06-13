package haru.task.manager.api

import org.springframework.web.bind.annotation.GetMapping

interface TaskService {

  @GetMapping(value = "/api/v1/tasks", produces = arrayOf("application/json"))
  fun getTasks(): List<Task>
  
}