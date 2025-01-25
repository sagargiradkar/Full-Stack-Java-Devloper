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

//		CoronaVaccine vaccine = new CoronaVaccine("Covaxin", "Bharat-Biotech", "IND", 234.4, 3);
//		service.searchVaccineByGivenData(vaccine,true,"price");

		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(14L);
		list.add(16L);
		String status = service.removeVaccinesByregNo(list);
		System.out.println(status);

		factory.close();
	}

}
