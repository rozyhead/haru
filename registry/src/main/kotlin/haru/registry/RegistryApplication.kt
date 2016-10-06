package haru.registry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 * @author takeshi
 */
@EnableEurekaServer
@SpringBootApplication
open class RegistryApplication {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(RegistryApplication::class.java, *args)
    }
  }

}

