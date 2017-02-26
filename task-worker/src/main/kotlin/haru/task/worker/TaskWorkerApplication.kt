package haru.task.worker

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
class TaskWorkerApplication {

  @Bean
  fun jacksonKotlinModule() = KotlinModule()

}

fun main(args: Array<String>) {
  SpringApplication.run(TaskWorkerApplication::class.java, *args)
}
