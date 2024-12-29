package com.sagar.test;

import com.sagar.comp.Employee;
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

        Employee employee = context.getBean(Employee.class);
        System.out.println(employee);

        System.out.println("Container is Closing ...");
        context.close();

    }
}
