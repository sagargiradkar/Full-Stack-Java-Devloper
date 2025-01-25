package in.ineuron;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtSerice;
import in.ineuron.type.ResultView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtSerice service = factory.getBean(ICoronaVaccineMgmtSerice.class);

		List<ResultView> listVaccines = service.searchVaccineByStartPrice(200.0);
		listVaccines.forEach(vaccine ->{
			System.out.println(vaccine.getName()+" "+vaccine.getCountry());
		});
		factory.close();
	}

}
