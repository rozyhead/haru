package haru.monitor

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.netflix.turbine.EnableTurbine

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
open class MonitorApplication {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(MonitorApplication::class.java, *args)
    }
  }

}