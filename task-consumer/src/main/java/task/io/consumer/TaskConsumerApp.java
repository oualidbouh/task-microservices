package task.io.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(TaskConsumerApp.class,args);
    }
}
