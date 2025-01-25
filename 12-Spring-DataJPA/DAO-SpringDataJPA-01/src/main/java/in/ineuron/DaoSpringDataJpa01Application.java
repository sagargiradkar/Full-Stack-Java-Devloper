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

/*

	service.fetchAllDetailes().forEach(System.out::println);
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		Iterable<CoronaVaccine> records = service.fetchAllDetailsById(ids);
		records.forEach(System.out::println);
		System.out.println("Checking for availability for the id :: 3L is => "+service.checkAvailabiltyByRegNo(3L));

		System.out.println("Total No. of vaccines count is :: "+service.getVaccineCount());
		List<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();
		vaccines.add(new CoronaVaccine("sputnik","russie","Russia",66.3,2));
		vaccines.add(new CoronaVaccine("pyzer","pyzerwer","USA",234.4,5));
		vaccines.add(new CoronaVaccine("moderena","moderna","USA",234.4,8));
		Iterable<CoronaVaccine> listVaccines = service.registerInBatch(vaccines);
		listVaccines.forEach(vaccine-> System.out.println(vaccine.getRegNo()));
		CoronaVaccine vaccine = new CoronaVaccine("covidshield","serum","IND",750.6,2);

		System.out.println(service.registerVaccine(vaccine));
		Optional<CoronaVaccine> optional = service.fetchVaccineById(38L);
		if(optional.isPresent()){
			System.out.println(optional.get());
		}
		optional.orElseThrow(()->new IllegalArgumentException("Record not found "));


		System.out.println(service.fetchVaccineById(30L).orElse(new CoronaVaccine()));
*/

		//System.out.println(service.removeVaccineById(3L));

		//System.out.println(service.removeVaccineById(2L));
		//CoronaVaccine vaccine = new CoronaVaccine("covidshield","serum","IND",750.6,2);
		//System.out.println(service.removeVaccineByObject(vaccine));

		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(6L);
		list.add(5L);
		System.out.println(service.removeVaccinesById(list));
		factory.close();
	}

}
