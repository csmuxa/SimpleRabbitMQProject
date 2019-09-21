package com.rabbit.rabbitListener.rabbitConfigs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQQueueConfiguration {


    @Bean
    Queue topicQueue(){
        return QueueBuilder.durable("topicQueue").autoDelete().exclusive().build();
    }



    @Bean
    Queue fanoutQueue(){
        return QueueBuilder.durable("fanoutQueue").autoDelete().exclusive().build();
    }

    @Bean
    Queue directQueue(){
        return QueueBuilder.durable("directQueue").autoDelete().exclusive().build();
    }

    @Bean
    Queue headersQueue(){
        return QueueBuilder.durable("headersQueue").autoDelete().exclusive().build();
    }

}
