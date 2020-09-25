package com.example.jms.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
public class JmsConsumer {

    @JmsListener(destination = "${jms.activemq.queue.respmsg}", containerFactory="jsmFactory")
    public void appleReceive(String msg, @Header("type") String message) {
            System.out.println("Recieved msg: " + msg);
    }
}
