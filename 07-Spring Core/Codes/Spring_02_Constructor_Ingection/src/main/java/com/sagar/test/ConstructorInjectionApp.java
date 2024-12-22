package com.sagar.test;

import com.sagar.comp.WishMessageGenerator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class ConstructorInjectionApp
{
    public static void main( String[] args )
    {
        FileSystemResource resource = new FileSystemResource("src/main/java/com/sagar/cfg/applicationContext.xml");

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("Bean Factory Container Starting ...");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("Bean Factory Container started ...");

        WishMessageGenerator wishmessage =  factory.getBean("wmg",WishMessageGenerator.class);
        System.out.println(wishmessage);

        String result = wishmessage.generateMessage("kohali");
        System.out.println(result);
    }
}
