package com.example.jms.jms;


import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;


@Component
public class JmsResponseProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.activemq.queue.producer}")
    String queue;

    public void sendAndReceive(String msg) {
        jmsTemplate.convertAndSend(queue, msg, new MessagePostProcessor() {
            public Message postProcessMessage(Message message) throws JMSException {
                message.setStringProperty("message", msg);
                return message;
            }
        });
    }
}