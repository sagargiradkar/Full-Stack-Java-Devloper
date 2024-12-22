package com.sagar.test;

import com.sagar.comp.WishMessageGenerator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class SetterInjection
{
    public static void main( String[] args )
    {
        FileSystemResource resource = new FileSystemResource("src/main/java/com/sagar/cfg/applicationContext.xml");

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("Barm Factory Container Starting ...");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("Barm Factory Container started ...");

        //Getting the bean from the container
        WishMessageGenerator wmg =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);

        //Using the bean
        System.out.println(wmg);
        String result = wmg.generateMessage("Sagar");
        System.out.println(result);

        //Closing the Container
        System.out.println("Container is Closing ...");

    }
}
