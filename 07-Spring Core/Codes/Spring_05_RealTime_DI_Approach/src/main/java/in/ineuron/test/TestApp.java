package in.ineuron.test;

import in.ineuron.comp.Flipkart;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

public class TestApp {
    public static void main(String[] args) throws IOException {
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions("in/ineuron/cfg/applicationContext.xml");
        System.out.println("****** Container Started ********\n");
        ApplicationContext factory = new FileSystemXmlApplicationContext("src/main/java/in/ineuron/cfg/applicationContext.xml");
        System.out.println();
       // System.in.read();
        Flipkart flipkart = factory.getBean("fpkt", Flipkart.class);
        System.out.println(flipkart);
        String result = flipkart.doShopping(new String[]{"fossils","tissot"},new Float[]{2344.34f,324.345f});
        System.out.println(result);
        System.out.println("****** Container Ended ********");
    }
}
