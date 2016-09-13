package haru.worker

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author takeshi
 */
@SpringBootApplication
object HaruWorker {

  @JvmStatic
  fun main(args: Array<String>) {
    SpringApplication.run(HaruWorker::class.java, *args)
  }

}
