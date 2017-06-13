package haru.task.worker.port.adapter.manager

import haru.task.manager.api.TaskServiceClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class EngineTaskMonitor(
    val taskServiceClient: TaskServiceClient
) {

  val log: Logger = LoggerFactory.getLogger(this.javaClass)

  @Scheduled(fixedDelay = 5000)
  fun getEngineTasks(): Unit {
    val tasks = taskServiceClient.getTasks()
    log.info("tasks = {}", tasks)
  }

}
