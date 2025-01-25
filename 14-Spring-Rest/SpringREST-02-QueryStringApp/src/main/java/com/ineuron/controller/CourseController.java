package com.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @GetMapping("/info/{id}")
    public ResponseEntity<String> getCurseInfo(@PathVariable Integer id){

        String body = null;
        if(id == 5){
            body="SpringBoot microservices";
        }else if(id == 6){
            body = "java";
        }else {
            body="No";
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }


    @GetMapping("/info/{id}/JRTP/{name}")
    public ResponseEntity<String> getCourseDetails(@PathVariable Integer id,
                                                   @PathVariable String name){

        String body = null;
        if(id == 5 && name.equalsIgnoreCase("navinreddy")){
            body="SpringBoot microservices";
        }else if(id == 6 && name.equalsIgnoreCase("haider")){
            body = "java";
        }else {
            body="Contact ineuron website for information";
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
