import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableDiscoveryClient
object HaruEngine {

  @JvmStatic
  fun main(args: Array<String>) {
    SpringApplication.run(HaruEngine::class.java, *args)
  }

}

