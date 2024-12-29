package com.sagar.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class ClientApp
{
    public static void main( String[] args )
    {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("************** ApplicationContext Container Started **************");
        System.out.println("Bean Factory Container started ...");



        System.out.println("Container is Closing ...");
        ((AbstractApplicationContext)factory).close();

    }
}
