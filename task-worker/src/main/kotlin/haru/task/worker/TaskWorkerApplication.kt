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
open class TaskWorkerApplication {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(TaskWorkerApplication::class.java, *args)
    }
  }

  @Bean
  open fun jacksonKotlinModule(): KotlinModule {
    return KotlinModule()
  }

}
