package haru.engine.port.adapter.web;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author takeshi
 */
@RestController
public class TaskController {

  @Value
  public static class TaskJson {
    private final String name;
  }

  @GetMapping("/api/v1/tasks")
  public List<TaskJson> getTasks() {
    return Arrays.asList(new TaskJson("dummy"));
  }

}
