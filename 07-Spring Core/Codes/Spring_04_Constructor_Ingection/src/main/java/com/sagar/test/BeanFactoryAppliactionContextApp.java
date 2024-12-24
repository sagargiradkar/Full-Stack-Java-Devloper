package com.sagar.test;

import com.sagar.comp.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class BeanFactoryAppliactionContextApp {
    public static void main(String[] args) {
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");

        Student std1 = factory.getBean("std1",Student.class);
        System.out.println(std1);
        System.out.println();

        Student std2 = factory.getBean("std2",Student.class);
        System.out.println(std2);
        System.out.println();

        Student std3 = factory.getBean("std3",Student.class);
        System.out.println(std3);
        System.out.println();

        Student std4 = factory.getBean("std4",Student.class);
        System.out.println(std4);
        System.out.println();

        Student std5 = factory.getBean("std5",Student.class);
        System.out.println(std5);
        System.out.println();


    }
}
