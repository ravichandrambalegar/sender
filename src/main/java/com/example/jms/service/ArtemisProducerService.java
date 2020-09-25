package com.example.jms.service;

import com.example.jms.jms.ArtemisProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArtemisProducerService {
    @Autowired
    ArtemisProducer producer;
    public  void sendMessage(String msg){
        producer.send(msg);
    }
}