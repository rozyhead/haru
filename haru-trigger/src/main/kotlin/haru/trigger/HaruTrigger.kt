package haru.trigger

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableDiscoveryClient
open class HaruTrigger {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(HaruTrigger::class.java, *args)
    }
  }

}
