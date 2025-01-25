package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.type.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("service")
public class CoronaVaccineMgmtService implements ICoronaVaccineMgmtSerice{

    @Autowired
    private ICoronaVaccineRepo repo;


    @Override
    public List<ResultView> searchVaccineByStartPrice(Double price) {

        System.out.println("Get Class name ::"+repo.getClass().getName());
        return repo.findByPriceGreaterThanEqualOrderByPrice(price);
    }
}
