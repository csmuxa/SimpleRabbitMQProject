package com.rabbit.rabbitListener.rabbitConfigs;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {


    //Topic exchanges route messages to queues based on wildcard matches between the routing key
    // and something called the routing pattern specified by the queue binding.
    @Bean
    Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("topicExchange").autoDelete().internal().build();
    }

    //A message goes to the queue(s) whose binding key exactly matches the routing key of the message.
    @Bean
    Exchange directExchange() {
        return ExchangeBuilder.directExchange("directExchange").autoDelete().internal().build();
    }

    //The fanout copies and routes a received message to all queues that are bound to it regardless of routing keys
    // or pattern matching as with direct and topic exchanges. Keys provided will simply be ignored.
    @Bean
    Exchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("fanoutExchange").autoDelete().internal().build();
    }

    //Headers exchanges route based on arguments containing headers and optional values.
    // Headers exchanges are very similar to topic exchanges, but it routes based on header values instead of routing keys.
    // A message is considered matching if the value of the header equals the value specified upon binding.
    @Bean
    Exchange headersExchange() {
        return ExchangeBuilder.headersExchange("headersExchange").autoDelete().internal().build();
    }
}
