package com.rabbit.rabbitListener.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.rabbitListener.transportModels.SimpleModel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


public class RabbitMQMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModel simpleModel = new SimpleModel();
        try {
            simpleModel = mapper.readValue(message.getBody(), SimpleModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(simpleModel);
    }
}
