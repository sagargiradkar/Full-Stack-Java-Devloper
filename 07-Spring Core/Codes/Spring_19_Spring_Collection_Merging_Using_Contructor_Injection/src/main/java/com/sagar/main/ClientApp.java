package com.sagar.main;


import com.sagar.comp.EnggCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class ClientApp {
    public static void main(String[] args) {
        System.out.println("************** ApplicationContext Container Starting **************");

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");

        EnggCourse cseCourse = (EnggCourse) context.getBean("CSE");

        System.out.println(cseCourse);
    }
}
