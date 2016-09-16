package haru.engine.api

import org.springframework.stereotype.Component

/**
 * @author takeshi
 */
@Component
open class TaskServiceFeignClientFallback : TaskServiceFeignClient {

  override fun getTasks(): List<Task> {
    return listOf(Task("fallback"))
  }

}