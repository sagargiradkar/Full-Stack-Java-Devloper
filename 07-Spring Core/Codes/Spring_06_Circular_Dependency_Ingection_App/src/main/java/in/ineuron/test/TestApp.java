package in.ineuron.test;

import in.ineuron.comp.A;
import in.ineuron.comp.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

public class TestApp {
    public static void main(String[] args) throws IOException {
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions("in/ineuron/cfg/applicationContext.xml");
        System.out.println("****** Container Started ********\n");
        //ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/in/ineuron/cfg/applicationContext.xml");
        System.out.println();
        System.in.read();
        A aObj = factory.getBean("a1", A.class);
        System.out.println();

        B bObj = factory.getBean("b1", B.class);
        System.out.println();

        System.out.println("****** Container Ended ********");
    }
}
