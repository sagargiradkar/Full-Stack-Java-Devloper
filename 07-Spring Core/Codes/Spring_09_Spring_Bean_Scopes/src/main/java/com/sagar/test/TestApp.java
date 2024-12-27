package com.sagar.test;

import com.sagar.comp.WishMessageGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("com/sagar/cfg/applicationContext.xml");
    //Activate the IOC Container (XMLBeanFactory)
        System.out.println("ApplicationContext Container Starting ...");
       // ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("com/sagar/cfg/applicationContext.xml");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("Bean Factory Container started ...");



        WishMessageGenerator wmg1 = factory.getBean("wmg1",WishMessageGenerator.class);
        System.out.println(wmg1+" available at ::"+wmg1.hashCode());

        WishMessageGenerator wmg2 = factory.getBean("wmg2",WishMessageGenerator.class);
        System.out.println(wmg2+" available at ::"+wmg2.hashCode());


    }
}
