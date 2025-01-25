package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class CoronaVaccineMgmtService implements ICoronaVaccineMgmtSerice{

    @Autowired
    private ICoronaVaccineRepo repo;

    @Override
    public List<CoronaVaccine> searchVaccineByGivenData(CoronaVaccine vaccine, boolean ascOrder, String... properties) {

        System.out.println("Proxy class is ::"+repo.getClass().getName());

        Example<CoronaVaccine> example = Example.of(vaccine);
        Sort sort = Sort.by(ascOrder ? Sort.Direction.ASC : Sort.Direction.DESC,properties);

        return repo.findAll(example, sort);
    }

    @Override
    public String removeVaccinesByregNo(Iterable<Long> regNo) {

        List<CoronaVaccine> listEntities = repo.findAllById(regNo);
        if(listEntities.size() != 0){
            repo.deleteAllByIdInBatch(regNo);
            return listEntities.size() +" no of records deleted ";

        }
        return "record not found for deletion";
    }
}
