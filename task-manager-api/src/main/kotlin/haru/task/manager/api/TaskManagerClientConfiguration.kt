package haru.task.manager.api

import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * @author takeshi
 */
@Configuration
@ComponentScan
@EnableFeignClients
open class TaskManagerClientConfiguration {
}