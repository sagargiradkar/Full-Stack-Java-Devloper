package com.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class ActorServiceConsumingRunner {


    public void run(String...args) throws Exception{
        RestTemplate template = new RestTemplate();
        String serviceUrl = "http://localhost:9090/myapp/api/actor/wish";

        ResponseEntity<String> responseEntity = template.getForEntity(serviceUrl, String.class);
        System.out.println("Response body               ::"+responseEntity.getBody());
        System.out.println("Response status code value  :: "+responseEntity.getStatusCodeValue());
        System.out.println("Response STatus code         ::"+responseEntity.getStatusCode());
    }
}
