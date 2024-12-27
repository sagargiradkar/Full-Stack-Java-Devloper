package com.sagar.test;

import com.sagar.comp.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) throws IOException {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("ApplicationContext Container Starting ...");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("ApplicationContext Container Started ...");
        System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
        System.in.read();

        Student student = factory.getBean("com.sagar.comp.Student#0",Student.class);
        System.out.println(student);

        Student student1 = factory.getBean("com.sagar.comp.Student#1",Student.class);
        System.out.println(student1);


        System.out.println("ApplicationContext Container Stoped");
    }
}
