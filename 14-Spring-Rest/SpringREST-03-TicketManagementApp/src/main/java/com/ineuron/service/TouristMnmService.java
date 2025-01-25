package com.ineuron.service;

import com.ineuron.dao.ITouristRepository;
import com.ineuron.exception.TouristNotFoundException;
import com.ineuron.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristMnmService implements ITouristMgmtService {

    @Autowired
    private ITouristRepository repository;

    @Override
    public String registerTourst(Tourist tourist) {
        Integer tid = repository.save(tourist).getTid();
        return "Tourist is registered having the ticket id ::" + tid;
    }

    @Override
    public List<Tourist> fetchAllTourit() {

        List<Tourist> list = repository.findAll();
        list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));

        return list;
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
        Optional<Tourist> optional = repository.findById(id);
        /*if(optional.isPresent()){
            return optional.get();
        }else {
             throw new TouristNotFoundException(id+" ::tourist not found");
        }*/
        return repository.findById(id)
                .orElseThrow(() -> new TouristNotFoundException("Tourist with id :: " + id + " not found"));

    }

    @Override
    public String updateTouristByDetails(Tourist tourist) {

        Optional<Tourist> optional = repository.findById(tourist.getTid());
        if (optional.isPresent()) {
            repository.save(tourist);
            return "Tourist with the id ::"
                    + tourist.getTid() + " Updated ";
        } else {
            throw new TouristNotFoundException("Tourist with the id :: " + tourist.getTid() + " Not available for update");
        }


    }

    @Override
    public String updateTouristById(Integer id, Double hikePercent) {
        Optional<Tourist> optional = repository.findById(id);
        if(optional.isPresent()){
            Tourist tourist = optional.get();
            tourist.setBudget(tourist.getBudget()+(tourist.getBudget()+(hikePercent/100)));
            return "Tourist budget is updated for the id :: "+ tourist.getTid();
        }
        else {
            throw new TouristNotFoundException("Tourist not fount for the id :: "+id);
        }
    }

    @Override
    public String deleteTouristById(Integer id) {
        Optional<Tourist> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
            return "Tourist with the id :: "+id+" is deleted ";
        }
        else {
            throw new TouristNotFoundException("Tourist not fount for the id :: "+id);
        }
    }
}