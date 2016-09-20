package haru.engine.api.task

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.stereotype.Component

/**
 * @author takeshi
 */
@FeignClient(value = "haru-engine", fallback = TaskServiceFeignClient.Fallback::class)
interface TaskServiceFeignClient : TaskService {

  @Component
  open class Fallback : TaskServiceFeignClient {

    override fun getTasks(): List<Task> {
      return listOf()
    }

  }

}