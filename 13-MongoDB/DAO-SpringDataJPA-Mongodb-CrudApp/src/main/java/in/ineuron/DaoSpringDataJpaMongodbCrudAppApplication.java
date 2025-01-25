package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgnmtService;

@SpringBootApplication
public class DaoSpringDataJpaMongodbCrudAppApplication {

	public static void main(String[] args) {
	 ApplicationContext applicationContext = SpringApplication.run(DaoSpringDataJpaMongodbCrudAppApplication.class, args);
	 
	 ICustomerMgnmtService service = applicationContext.getBean(ICustomerMgnmtService.class);
	 
	 
	 
	 
	 System.out.println(service.registerCustomer(new CustomerDTO(1, "Rahul", 120.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(2, "Amit", 200.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(3, "Priya", 150.5f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(4, "Neha", 175.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(5, "Ramesh", 220.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(6, "Suresh", 80.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(7, "Alok", 300.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(8, "Sunita", 95.5f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(9, "Ritika", 130.0f)));
	 System.out.println(service.registerCustomer(new CustomerDTO(10, "Sachin", 100.0f)));
	 service.getAllCustomers().forEach(System.out::println);;
	//System.out.println( service.deleteCustomerById("678e0daa9bdb574a3fc3a0e8"));
	 service.getAllCustomers().forEach(System.out::println);;
		
	 ((ConfigurableApplicationContext) applicationContext).close();
	}

}
