package in.ineuron;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.comp.Company;
import in.ineuron.comp.Company2;

@SpringBootApplication
public class BootProj04BulkLoadingAppApplication {

	public static void main(String[] args) throws Exception {
	 ApplicationContext context =SpringApplication.run(BootProj04BulkLoadingAppApplication.class, args);
	 
	 Company company = context.getBean(Company.class);
	 System.out.println(company);
	 
	 System.in.read();
	 
	 Company2 company2 = context.getBean(Company2.class);
	 System.out.println(company2);
	 
	}

}
