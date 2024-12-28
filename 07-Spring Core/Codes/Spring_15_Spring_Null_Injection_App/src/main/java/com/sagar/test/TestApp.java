package com.sagar.test;

import com.sagar.comp.PersonalInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) throws IOException {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println(" ************** ApplicationContext Container Starting ********** ");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println(" ************** ApplicationContext Container Started ************** ");
        System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
        System.in.read();

        PersonalInfo personalInfo = factory.getBean("pInfo",PersonalInfo.class);
        System.out.println(personalInfo);

        System.out.println("\n********* ApplicationContext Container Stop **********");
    }
}
