package com.sagar.test;

import com.sagar.comp.Student;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class TestApp {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");

        Student std1 = context.getBean("std1", Student.class);
        System.out.println(std1);

//        Student std2 = context.getBean("std2", Student.class);
//        System.out.println(std2);
//
//        Student std3 = context.getBean("std3", Student.class);
//        System.out.println(std3);
//
//        Student std4 = context.getBean("std4", Student.class);
//        System.out.println(std4);

    }
}
