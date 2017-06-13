package haru.task.manager.api

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.stereotype.Component

@FeignClient(value = "task-manager", fallback = TaskServiceFeignClient.Fallback::class)
interface TaskServiceFeignClient : TaskService {

  @Component
  class Fallback : TaskServiceFeignClient {

    override fun getTasks(): List<Task> {
      return listOf()
    }

  }

}