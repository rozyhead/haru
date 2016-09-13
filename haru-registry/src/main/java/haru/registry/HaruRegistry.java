package haru.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author takeshi
 */
@EnableEurekaServer
@SpringBootApplication
public class HaruRegistry {

  public static void main(String[] args) {
    SpringApplication.run(HaruRegistry.class, args);
  }

}
