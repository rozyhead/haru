package haru.task.manager.api

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.stereotype.Component

@FeignClient(value = "task-manager", fallback = TaskServiceClient.Fallback::class)
interface TaskServiceClient : TaskService {

  @Component
  class Fallback : TaskServiceClient {

    override fun getTasks(): List<Task> {
      return listOf()
    }

  }

}