package haru.worker

import com.fasterxml.jackson.module.kotlin.KotlinModule
import haru.engine.api.EnableTaskServiceFeignClient
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTaskServiceFeignClient
open class HaruWorker {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(HaruWorker::class.java, *args)
    }
  }

  @Bean
  open fun jacksonKotlinModule(): KotlinModule {
    return KotlinModule()
  }

}
