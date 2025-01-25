package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
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
    public List<CoronaVaccine> fetchVaccineByCompany(String company) {
        System.out.println(repo.getClass()+" "+ Arrays.toString(repo.getClass().getDeclaredMethods()));
        List<CoronaVaccine> listEntities = repo.findByCompany(company);

        return listEntities;
    }
}
