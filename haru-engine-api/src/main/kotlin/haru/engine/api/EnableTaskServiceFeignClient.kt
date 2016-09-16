package haru.engine.api

import org.springframework.context.annotation.Import

/**
 * @author takeshi
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(TaskServiceFeignClientConfiguration::class)
annotation class EnableTaskServiceFeignClient
