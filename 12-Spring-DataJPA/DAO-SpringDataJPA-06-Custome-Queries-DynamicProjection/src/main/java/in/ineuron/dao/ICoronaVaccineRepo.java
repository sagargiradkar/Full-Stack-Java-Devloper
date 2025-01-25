package in.ineuron.dao;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Long> {

    public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(Double price);
}
