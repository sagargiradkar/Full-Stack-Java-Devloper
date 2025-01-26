package com.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ActorServiceConsumingRunner_PathVariable {


    public void run(String...args) throws Exception{
        RestTemplate template = new RestTemplate();
        String serviceUrl = "http://localhost:9090/myapp/api/actor/wish";

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("id", 7);
        map.put("name", "Sachin");
        ResponseEntity<String> responseEntity = template.getForEntity(serviceUrl, String.class,map);
        System.out.println("Response body               ::"+responseEntity.getBody());
        System.out.println("Response status code value  :: "+responseEntity.getStatusCodeValue());
        System.out.println("Response STatus code         ::"+responseEntity.getStatusCode());
    }
}
