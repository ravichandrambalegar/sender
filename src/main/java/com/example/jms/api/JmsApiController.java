package com.example.jms.api;

import com.example.jms.service.ArtemisProducerService;
import com.example.jms.service.ArtemisPublisherService;
import com.example.jms.service.ArtemisResponseProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsApiController {
    @Autowired
    ArtemisProducerService artemisProducerService;

    @Autowired
    ArtemisPublisherService artemisPublisherService;

    @Autowired
    ArtemisResponseProducerService artemisResponseProducerService;

    @RequestMapping(value="/produce")
    public String produce(@RequestParam("msg")String msg){
        artemisProducerService.sendMessage(msg);
        return "produce Done";
    }

    @RequestMapping(value="/produce_consume")
    public String produceConsume(@RequestParam("msg")String msg){
        artemisResponseProducerService.sendAndReceiveMessage(msg);
        return "produce_consume Done";
    }

    @RequestMapping(value="/publish")
    public String publish(){
        artemisPublisherService.publishMessage();
        return "publish Done";
    }
}


