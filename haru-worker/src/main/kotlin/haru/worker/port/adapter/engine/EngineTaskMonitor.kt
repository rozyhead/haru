package haru.worker.port.adapter.engine

import haru.engine.api.task.TaskServiceFeignClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import javax.inject.Inject

/**
 * @author takeshi
 */
@Component
open class EngineTaskMonitor @Inject constructor(
    val taskServiceFeignClient: TaskServiceFeignClient) {

  val log: Logger = LoggerFactory.getLogger(this.javaClass)

  @Scheduled(fixedDelay = 5000)
  fun getEngineTasks(): Unit {
    val tasks = taskServiceFeignClient.getTasks()
    log.info("tasks = {}", tasks)
  }
}
