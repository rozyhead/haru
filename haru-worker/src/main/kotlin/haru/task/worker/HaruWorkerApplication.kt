package haru.task.worker

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TaskWorkerApplication

fun main(args: Array<String>) {
  SpringApplication.run(TaskWorkerApplication::class.java, *args)
}
