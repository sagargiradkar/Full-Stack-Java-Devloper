package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.Employee;

@SpringBootApplication
public class BootProj05ValueAnnotationAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj05ValueAnnotationAppApplication.class, args);

		Employee employee = context.getBean(Employee.class);
		System.out.println(employee);

		((ConfigurableApplicationContext) context).close();
	}

}
