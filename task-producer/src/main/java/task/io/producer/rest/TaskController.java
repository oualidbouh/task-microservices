package task.io.producer.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import task.io.core.dto.TaskDTO;
import task.io.producer.services.TaskService;

@RestController
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity createTask(@RequestBody TaskDTO taskDTO){
        Assert.notNull(taskDTO,"task must not be null");
        taskService.sendTask(taskDTO);
        return ResponseEntity.ok().build();
    }
}
