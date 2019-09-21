package com.rabbit.rabbitProducer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.rabbitProducer.TransportModels.SimpleModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonComponent;

@SpringBootApplication
public class RabbitProducerApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleModel simpleModel = new SimpleModel();
        simpleModel.setDescription("Just an example of that,how RabbitMQ works");
        simpleModel.setName("TestMessage");

        ObjectMapper mapper = new ObjectMapper();
        String JSONSimpleModel = mapper.writeValueAsString(simpleModel);

        rabbitTemplate.convertAndSend("myTopicExchange", "topic", JSONSimpleModel);
    }
}
