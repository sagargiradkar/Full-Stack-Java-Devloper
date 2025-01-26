package com.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/actor")
public class ActorOperationsController {

    @GetMapping("/wish")
    public ResponseEntity<String> displayWishmessage(){
        LocalDateTime ldt = LocalDateTime.now();
        int hour = ldt.getHour();
        String body = null;
        if(hour < 12){
            body = "Good Morning";
        }else if(hour <16){
            body = "Good Afternoon";
        }else if(hour <20){
            body = "Good Evening";
        }else {
            body="Good Night";
        }

        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
    
    @GetMapping("/wish/{id}/{name}")
    public ResponseEntity<String> displayWishMessage(@PathVariable Integer id,@PathVariable String name){
    	LocalDateTime ldt = LocalDateTime.now();
        int hour = ldt.getHour();
        String body = null;
        if(hour < 12){
            body = "Good Morning" + name+"Associated id is ::"+id;
        }else if(hour <16){
            body = "Good Afternoon"+ name+"Associated id is ::"+id;
        }else if(hour <20){
            body = "Good Evening"+ name+"Associated id is ::"+id;
        }else {
            body="Good Night"+ name+"Associated id is ::"+id;
        }

        return new ResponseEntity<String>(body, HttpStatus.OK);
    
    }

}
