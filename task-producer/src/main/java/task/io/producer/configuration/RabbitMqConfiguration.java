package task.io.producer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    private String topicExchangeName;

    private String queueName;

    private String routingKey;

    public RabbitMqConfiguration( @Value("${task.exchange.name}") String topicExchangeName, @Value("${task.queue.name}") String queueName, @Value("${task.routingKey.name}") String routingKey){
        this.topicExchangeName = topicExchangeName;
        this.queueName = queueName;
        this.routingKey = routingKey;
    }

    @Bean
    Queue queue() {
        return new Queue(queueName);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
