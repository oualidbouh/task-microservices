package task.io.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.io.consumer.service.TaskService;
import task.io.core.dto.TaskDTO;

@Component
public class Receiver {

    @Autowired
    private TaskService taskService;

    public void receiveMessage(TaskDTO taskDTO){
        taskService.saveTask(taskDTO);
    }
}
