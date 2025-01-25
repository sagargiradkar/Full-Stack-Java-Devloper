package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;

import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtSerice {

    public String registerVaccine(CoronaVaccine coronaVaccine);
    public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
    public Long getVaccineCount();
    public boolean checkAvailabiltyByRegNo(Long RegNo);
    public Iterable<CoronaVaccine> fetchAllDetailes();
    public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids);
    public Optional<CoronaVaccine> fetchVaccineById(Long id);
    public String removeVaccineById(Long id);
    public String removeVaccineByObject(CoronaVaccine vaccine);
    public String removeVaccinesById(List<Long> ids);
    }
