package com.sagar.test;

import com.sagar.comp.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) throws IOException {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println(" ************** ApplicationContext Container Starting ********** ");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/com/sagar/cfg/applicationContext.xml");
        System.out.println(" ************** ApplicationContext Container Started ************** ");
        System.out.println("Bean id is :: "+Arrays.toString(factory.getBeanDefinitionNames()));
        System.out.println();

        Car car1 = factory.getBean("car1", Car.class);
        System.out.println(car1+"\t hashCode :: "+car1.hashCode());

        System.out.println();

        Car car2 = factory.getBean("car2", Car.class);
        System.out.println(car2+"\t hashCode :: "+car2.hashCode());

        System.out.println();

//        Car baseCar = factory.getBean("baseCar", Car.class);
//        System.out.println(baseCar);

        System.out.println("\n********* ApplicationContext Container Stop **********");
    }
}
