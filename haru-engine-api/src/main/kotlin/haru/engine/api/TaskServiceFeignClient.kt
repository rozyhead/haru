package haru.engine.api

import org.springframework.cloud.netflix.feign.FeignClient

/**
 * @author takeshi
 */
@FeignClient(value = "haru-engine", fallback = TaskServiceFeignClientFallback::class)
interface TaskServiceFeignClient : TaskService {
}