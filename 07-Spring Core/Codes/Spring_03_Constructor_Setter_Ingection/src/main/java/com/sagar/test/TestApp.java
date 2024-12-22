package com.sagar.test;

import com.sagar.comp.WishMessageGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("com/sagar/cfg/applicationContext.xml");
    //Activate the IOC Container (XMLBeanFactory)
        System.out.println("ApplicationContext Container Starting ...");
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("com/sagar/cfg/applicationContext.xml");
        System.out.println("Bean Factory Container started ...");


        System.out.println("Bean count is :: "+factory.getBeanDefinitionCount());
        System.out.println("Bean id is    :: "+ Arrays.toString(factory.getBeanDefinitionNames()));

        WishMessageGenerator wmg = factory.getBean("wmg",WishMessageGenerator.class);
        System.out.println(wmg);

        factory.close();

    }
}
