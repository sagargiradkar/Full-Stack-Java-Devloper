package in.ineuron.test;

import java.util.Scanner;

import in.ineuron.cfg.AppConfig;
import in.ineuron.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestApp {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("************Container Started***************");

        MainController controller = context.getBean(MainController.class);
        System.out.println(context);

        System.out.println("\n************Container Stopped***************");

    }

}