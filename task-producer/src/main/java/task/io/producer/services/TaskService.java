package task.io.producer.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import task.io.core.dto.TaskDTO;

@Service
public class TaskService {

    private final RabbitTemplate rabbitTempalte;
    private final Queue queue;

    public TaskService(RabbitTemplate rabbitTemplate, Queue queue){
        this.rabbitTempalte = rabbitTemplate;
        this.queue = queue;
    }

    public void sendTask(TaskDTO taskDTO){
        rabbitTempalte.convertAndSend(queue.getName() ,taskDTO);
    }
}
