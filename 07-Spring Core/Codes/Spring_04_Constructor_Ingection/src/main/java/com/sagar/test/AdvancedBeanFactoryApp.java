package com.sagar.test;

import com.sagar.comp.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;


public class AdvancedBeanFactoryApp {
    public static void main(String[] args) throws IOException {


        DefaultListableBeanFactory factory = null;
        XmlBeanDefinitionReader reader = null;

        factory = new DefaultListableBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("com/sagar/cfg/applicationContext.xml");
        System.out.println("Container Started ");

        System.in.read();
        Student student = factory.getBean("std1",Student.class);
        System.out.println(student);











//
//        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
//
//        Student std1 = factory.getBean("std1",Student.class);
//        System.out.println(std1);
//        System.out.println();
//
//        Student std2 = factory.getBean("std2",Student.class);
//        System.out.println(std2);
//        System.out.println();
//
//        Student std3 = factory.getBean("std3",Student.class);
//        System.out.println(std3);
//        System.out.println();
//
//        Student std4 = factory.getBean("std4",Student.class);
//        System.out.println(std4);
//        System.out.println();
//
//        Student std5 = factory.getBean("std5",Student.class);
//        System.out.println(std5);
//        System.out.println();
//

    }
}
