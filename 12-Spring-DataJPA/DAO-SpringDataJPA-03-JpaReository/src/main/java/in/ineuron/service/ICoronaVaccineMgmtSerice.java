package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;

import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtSerice {
    public List<CoronaVaccine> searchVaccineByGivenData(CoronaVaccine vaccine,boolean ascOrder,String... properties);
    public String removeVaccinesByregNo(Iterable<Long> regNo);
    }
