package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;

import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtSerice {
    public List<CoronaVaccine> fetchVaccineByCompany(String company);
    }
