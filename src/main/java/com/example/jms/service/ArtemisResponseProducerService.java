package com.example.jms.service;

import com.example.jms.jms.JmsResponseProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtemisResponseProducerService {

    @Autowired
    JmsResponseProducer jmsResponseProducer;
    public  void sendAndReceiveMessage(String msg){
        jmsResponseProducer.sendAndReceive(msg);
    }
}
