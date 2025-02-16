package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.Student;

@SpringBootApplication
public class BootProj02DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);
		
		Student student = context.getBean(Student.class);
		System.out.println(student);
		
		student.preparation("java");
		
		((ConfigurableApplicationContext) context).close();
	}

}
