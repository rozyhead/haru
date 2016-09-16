package haru.registry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 * @author takeshi
 */
@EnableEurekaServer
@SpringBootApplication
open class HaruRegistry {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(HaruRegistry::class.java, *args)
    }
  }

}

