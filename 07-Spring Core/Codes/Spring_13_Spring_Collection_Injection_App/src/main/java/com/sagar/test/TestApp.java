package com.sagar.test;

import com.sagar.comp.College;
import com.sagar.comp.ContactInfo;
import com.sagar.comp.MarksInfo;
import com.sagar.comp.UnivercityDetailes;
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

        MarksInfo info = factory.getBean("marks",MarksInfo.class);
        System.out.println(info);

        System.out.println();
        College clg = factory.getBean("clg",College.class);
        System.out.println(clg);

        ContactInfo contactInfo = factory.getBean("contact",ContactInfo.class);
        System.out.println(contactInfo);

        UnivercityDetailes univercityDetailes = factory.getBean("uInfo",UnivercityDetailes.class);
        System.out.println(univercityDetailes);


        System.out.println("\n********* ApplicationContext Container Stop **********");
    }
}
