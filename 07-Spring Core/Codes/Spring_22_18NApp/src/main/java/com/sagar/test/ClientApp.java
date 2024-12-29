package com.sagar.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;

public class ClientApp
{
    public static void main( String[] args )
    {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("************** ApplicationContext Container Started **************");
        System.out.println("Bean Factory Container started ...");

        //Locale locale = new Locale(args[0],args[1]);
        Locale locale = new Locale("hi","IN");
        System.out.println(context.getMessage("btn1.cap", null, locale));
        System.out.println(context.getMessage("btn2.cap", null, locale));
        System.out.println(context.getMessage("btn3.cap", null, locale));
        System.out.println(context.getMessage("btn4.cap", null, locale));

        System.out.println();

      //  System.out.println(context.getMessage("btn1.cap", new String[] { "student" }, locale));


        System.out.println("Container is Closing ...");
        context.close();

    }
}
