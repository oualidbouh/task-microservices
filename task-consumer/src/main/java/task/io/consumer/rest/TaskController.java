package task.io.consumer.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.io.consumer.service.TaskService;
import task.rest.api.client.TaskClient;
import task.rest.api.client.dto.Task;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController implements TaskClient {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task getTaskById(Long id) {
       return taskService.getTaskById(id);
    }

    @Override
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
}
