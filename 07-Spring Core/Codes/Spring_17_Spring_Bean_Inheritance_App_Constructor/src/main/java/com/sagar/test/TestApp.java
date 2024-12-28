package com.sagar.test;

import com.sagar.comp.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) {

        // Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("************** ApplicationContext Container Started **************");

        System.out.println("Bean IDs: " + Arrays.toString(context.getBeanDefinitionNames()));

        Person child1 = context.getBean("childBean1", Person.class);
        System.out.println("Child Bean 1: " + child1);

        Person child2 = context.getBean("childBean2", Person.class);
        System.out.println("Child Bean 2: " + child2);

        System.out.println("\n************** ApplicationContext Container Stop **************");
    }
}
