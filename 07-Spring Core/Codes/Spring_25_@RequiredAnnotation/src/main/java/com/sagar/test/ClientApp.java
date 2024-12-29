package com.sagar.test;

import com.sagar.comp.PersonInfo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientApp
{
    public static void main( String[] args )
    {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");

        PersonInfo personInfo = context.getBean(PersonInfo.class);
        System.out.println(personInfo);
        System.out.println("*********** Container is Colsed *********");
        context.close();

    }
}
