package task.rest.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import task.rest.api.client.dto.Task;

import java.util.List;

@FeignClient
public interface TaskClient {

    @GetMapping("/tasks/{id}")
    Task getTaskById(@PathVariable Long id);

    @GetMapping("/tasks")
    List<Task> getTasks();
}
