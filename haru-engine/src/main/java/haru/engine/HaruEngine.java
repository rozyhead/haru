package haru.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author takeshi
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HaruEngine {

  public static void main(String[] args) {
    SpringApplication.run(HaruEngine.class, args);
  }

}
