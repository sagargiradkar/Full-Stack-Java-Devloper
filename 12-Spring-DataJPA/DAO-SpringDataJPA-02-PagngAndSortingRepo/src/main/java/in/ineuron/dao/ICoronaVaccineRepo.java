package in.ineuron.dao;

import in.ineuron.bo.CoronaVaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICoronaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine,Long> {

    long count();
}
