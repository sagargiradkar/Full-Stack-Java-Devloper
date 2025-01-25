package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class CoronaVaccineMgmtService implements ICoronaVaccineMgmtSerice{

    @Autowired
    private ICoronaVaccineRepo repo;

    @Override
    public String registerVaccine(CoronaVaccine coronaVaccine) {
        System.out.println("In memmory proxy class is :: "+repo.getClass().getName());

        CoronaVaccine saveVaccine = null;
        if(coronaVaccine != null){
            saveVaccine = repo.save(coronaVaccine);
        }
        return saveVaccine != null ? "vaccine registered successfully with "+saveVaccine.getRegNo()
                :" vaccine registration failed";
    }

    @Override
    public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {

        if(vaccines != null){
            return repo.saveAll(vaccines);
        }else{
            throw new IllegalArgumentException("Batch Insertion not done ..");
        }
    }

    @Override
    public Long getVaccineCount() {
        return repo.count();
    }

    @Override
    public boolean checkAvailabiltyByRegNo(Long RegNo) {
        return repo.existsById(RegNo);
    }

    @Override
    public Iterable<CoronaVaccine> fetchAllDetailes() {
        return repo.findAll();
    }

    @Override
    public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public Optional<CoronaVaccine> fetchVaccineById(Long id) {
        return repo.findById(id);
    }

    @Override
    public String removeVaccineById(Long id) {
        Optional<CoronaVaccine> optional = repo.findById(id);
        if(optional.isPresent()){
            repo.deleteById(id);
            return "Record Deleted Having ID ::"+id;
        }else{
            return "Record Not available for deletion";
        }

    }

    @Override
    public String removeVaccineByObject(CoronaVaccine vaccine) {
        Optional<CoronaVaccine> optional = repo.findById(vaccine.getRegNo());
        if(optional.isPresent()){
            repo.delete(vaccine);
            return "Record Deleted with the given id ::"+vaccine.getRegNo();
        }
        return "Record Not avialable for deletion with the given id :: "+vaccine.getRegNo();
    }

    @Override
    public String removeVaccinesById(List<Long> ids) {
       Iterable<CoronaVaccine> listEntities = repo.findAllById(ids);

       int count = ids.size();
       if(count == ((List) listEntities).size()){
           repo.findAllById(ids);
           return count+"Record Deteleted Succesfully having ids ";
       }


        return "Problem in deleting records";
    }


}
