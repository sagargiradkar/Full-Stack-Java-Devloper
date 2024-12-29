package com.sagar.test;

import com.sagar.comp.Voter;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class ClientApp
{
    public static void main( String[] args ) throws IOException {

        //Activate the IOC Container (XMLBeanFactory)
        System.out.println("************** ApplicationContext Container Starting **************\n");
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
        System.out.println("Bean id information :: "+ Arrays.toString(context.getBeanDefinitionNames()));

        System.in.read();

        Voter voter = context.getBean(Voter.class);
        System.out.println(voter);

        System.out.println(voter.checkVotingEligibility());

        System.out.println("\n*********** ApplicationContext Container Stopped *********");
        context.close();

    }
}
