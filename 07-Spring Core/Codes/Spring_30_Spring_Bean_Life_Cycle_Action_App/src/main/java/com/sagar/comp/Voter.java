package com.sagar.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component(value = "voter")
@PropertySource(value = "src/main/java/com/sagar/commons/application.properties")
public class Voter {

    @Value("${voter.info.name}")
    private String name;

    @Value("${voter.info.age}")
    private float age;

    private Date dov;

    static {
        System.out.println("voter.class file is loading ...");
    }

    public Voter(){
        System.out.println("voter object is instantiated ...");
    }

    @PostConstruct
    public void myInit(){
        System.out.println("Voter.myInit() method");
        dov = new Date();
        boolean flag = false;

        if(name == null){
            System.out.println("Name must be not be null");
            flag = true;
        }
        if(age <0 ){
            age = age * -1;
        }
        if(age >100){
            System.out.println("Age must nob be > 100");
            flag = true;
        }
        if(flag){
            throw new IllegalArgumentException("Invalid Input");
        }
    }
    //Business Logic method
    public String checkVotingEligibility(){
        System.out.println("Voter.checkVotingEligibility() method");
        if(age >= 18){
            return "Mr/Miss/Mrs: " + name +" you are eligible for voting : "+age + " -----> on "+dov;
        }else{
            return "Mr/Miss/Mrs: " + name +" you are eligible not for voting : "+age + " -----> on "+dov;
        }
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("Voter.myDestroy() method");

        //nullify the bean properties
        name = null;
        age = 0;
        dov = null;

    }
    @Override
    public String toString() {
        return "Voter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dov=" + dov +
                '}';
    }
}
