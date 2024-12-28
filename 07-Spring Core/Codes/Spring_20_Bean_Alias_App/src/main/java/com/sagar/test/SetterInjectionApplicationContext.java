package com.sagar.test;

import com.sagar.comp.WishMessageGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class SetterInjectionApplicationContext
{
    public static void main( String[] args )
    {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("************** ApplicationContext Container Started **************");
        System.out.println("Bean Factory Container started ...");

        System.out.println("\nNo of beans is :: "+factory.getBeanDefinitionCount());
        System.out.println("Bean id is :: "+ Arrays.toString(factory.getBeanDefinitionNames()));

        WishMessageGenerator wmg = factory.getBean("wmg",WishMessageGenerator.class);
        System.out.println("Hashcode of wmg is :: "+wmg.hashCode());
        System.out.println(wmg);

        WishMessageGenerator wishMessageGenerator = factory.getBean("WishMessageGenerator",WishMessageGenerator.class);
        System.out.println("\nHascode of WishMessageGenerator is :: "+wishMessageGenerator.hashCode());
        System.out.println(wishMessageGenerator);

        //Closing the Container
        System.out.println("Container is Closing ...");
        ((AbstractApplicationContext)factory).close();

    }
}
