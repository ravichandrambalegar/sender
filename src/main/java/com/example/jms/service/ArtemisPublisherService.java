package com.example.jms.service;

import com.example.jms.jms.ArtemisProducer;
import com.example.jms.jms.JmsPublisher;
import com.example.jms.model.Company;
import com.example.jms.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ArtemisPublisherService  {

    @Autowired
    JmsPublisher publisher;


    public  void publishMessage(){
        Product credProduct1 = new Product("cred");
        Product credProduct2 = new Product("loan");

        List<Product> credProducts = new ArrayList<Product>(Arrays.asList(credProduct1, credProduct2));

        Company credCompany = new Company("CRED", credProducts);

        credProduct1.setCompany(credCompany);
        credProduct2.setCompany(credCompany);

        publisher.send(credCompany);

        Product product1 = new Product("ResumeBuilder");

        List<Product> samsungProducts = new ArrayList<Product>(Arrays.asList(product1));

        Company social = new Company("(91Social)", samsungProducts);

        product1.setCompany(social);

        publisher.send(social);
    }



}