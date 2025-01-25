package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;

import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtSerice {
    public Iterable<CoronaVaccine> fetchDetails(boolean asc,String...properties);
    public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo,int pageSize,boolean asc,String...properties);
    public void fetchDetailsByPagination(int pageSize);
    }
