package haru.autoconfigure.jackson

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonKotlinModuleAutoConfiguration {

  @Bean
  fun jacksonKotlinModule() = KotlinModule()

}