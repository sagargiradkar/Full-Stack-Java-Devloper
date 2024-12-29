package com.sagar.test;

import com.sagar.comp.Flipkart;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class ClientApp
{
    public static void main( String[] args )
    {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        AbstractApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println("************** ApplicationContext Container Started **************");
        System.out.println("Bean Factory Container started ...");

        Flipkart flipkart = factory.getBean(Flipkart.class);
        System.out.println(flipkart.doShopping(new String[]{"tissut","oswal"},new Float[]{234.5f,454.546f}));

        System.out.println("Container is Closing ...");
        factory.close();

    }
}
