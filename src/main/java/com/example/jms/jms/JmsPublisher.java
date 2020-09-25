package com.example.jms.jms;

import com.example.jms.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class JmsPublisher {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.activemq.topic}")
    String topic;

    public void send(Company apple){
        jmsTemplate.convertAndSend(topic, apple);
    }
}
