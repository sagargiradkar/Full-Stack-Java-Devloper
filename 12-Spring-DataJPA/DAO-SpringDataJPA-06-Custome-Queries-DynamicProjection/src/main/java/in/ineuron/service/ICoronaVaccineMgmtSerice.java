package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;

import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtSerice {

   public List<ResultView>  searchVaccineByStartPrice(Double price);

     }
