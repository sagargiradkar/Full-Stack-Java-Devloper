package in.ineuron;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtSerice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtSerice service = factory.getBean(ICoronaVaccineMgmtSerice.class);
		//service.fetchDetails(true,"price","name").forEach(System.out::println);
/*

		service.fetchDetailsByPageNo(2,4,true,"price","name").forEach(System.out::println);
		service.fetchDetailsByPageNo(4,5,true,"price","name")
				.forEach((vaccine) -> System.out.println(vaccine.getPrice()+" == "+vaccine.getCountry()));
*/

		service.fetchDetailsByPagination(6);
		factory.close();
	}

}
