package haru.store

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableDiscoveryClient
open class HaruStore {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(HaruStore::class.java, *args)
    }
  }

}
