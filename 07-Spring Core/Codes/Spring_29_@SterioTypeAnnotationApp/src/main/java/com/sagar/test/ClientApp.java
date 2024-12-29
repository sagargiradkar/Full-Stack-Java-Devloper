package com.sagar.test;

import com.sagar.comp.Flipkart;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientApp
{
    public static void main( String[] args )
    {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************");
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");

        Flipkart flipkart = context.getBean("flipkart",Flipkart.class);
        System.out.println(flipkart.doShopping(new String[]{"tissot","omegha"},new Float[]{234.5f,454.546f}));


        System.out.println("*********** Container is Colsed *********");
        context.close();

    }
}
