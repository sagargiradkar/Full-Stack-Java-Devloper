package com.sagar.test;

import com.sagar.comp.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

public class TestApp {
    public static void main(String[] args) throws IOException {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("ApplicationContext Container Starting ...");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("ApplicationContext Container Started ...");
        System.in.read();
        Printer printer = factory.getBean("printer",Printer.class);
        System.out.println(printer);

        Printer printer2 = factory.getBean("printer",Printer.class);
        System.out.println(printer2);

        System.out.println("ApplicationContext Container Stoped");
    }
}
