package haru.engine

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableEurekaClient
open class HaruEngine {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(HaruEngine::class.java, *args)
    }
  }

}

