package task.io.consumer.service;

import org.springframework.stereotype.Service;
import task.io.consumer.client.UserClient;
import task.io.consumer.entity.Task;
import task.io.consumer.repository.TaskRepository;
import task.io.core.dto.TaskDTO;
import task.rest.api.client.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserClient userClient;

    public TaskService(TaskRepository taskRepository, UserClient userClient) {
        this.taskRepository = taskRepository;
        this.userClient = userClient;
    }

    public void saveTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setDesription(taskDTO.getName());
        task.setDone(taskDTO.isDone());
        task.setCreatedBy(userClient.getUserById(1L).getId());
        taskRepository.save(task);
    }

    public task.rest.api.client.dto.Task getTaskById(Long id){
        // Fetch the task using id from database
       Task task = taskRepository.getById(id);

       // Get user from gateway (using a feign client)
        UserDTO userDTO = userClient.getUserById(task.getCreatedBy());

        // Return final result
        return new task.rest.api.client.dto.Task(task.getId(),task.getDesription(),task.isDone(),userDTO);
    }

    public List<task.rest.api.client.dto.Task> getTasks(){
        List<Task> tasks = taskRepository.findAll();

        List<task.rest.api.client.dto.Task> result = new ArrayList();

        tasks.forEach(task -> {
            UserDTO userDTO = userClient.getUserById(task.getCreatedBy());
            result.add(new task.rest.api.client.dto.Task(task.getId(),task.getDesription(),task.isDone(),userDTO));
        });
        return result;
    }
}
