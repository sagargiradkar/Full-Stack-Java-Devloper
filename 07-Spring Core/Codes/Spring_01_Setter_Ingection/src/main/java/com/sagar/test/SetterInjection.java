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
        System.out.println("Bean Factory Container Starting ...");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("Bean Factory Container started ...");

        //Getting the bean from the container
        WishMessageGenerator wmg =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);

        //Using the bean
        System.out.println(wmg);
        String result = wmg.generateMessage("Sagar");
        System.out.println(result);
        System.out.println("Hashcode value of wmg is :: "+wmg.hashCode());

        WishMessageGenerator wmg1 =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);

        //Using the bean
        System.out.println(wmg1);
        String result1 = wmg.generateMessage("Pavan");
        System.out.println(result1);
        System.out.println("Hashcode value of wmg1 is :: "+wmg1.hashCode());

        //Closing the Container
        System.out.println("Container is Closing ...");

    }
}
