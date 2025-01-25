package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class CoronaVaccineMgmtService implements ICoronaVaccineMgmtSerice{

    @Autowired
    private ICoronaVaccineRepo repo;


    @Override
    public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
        Sort sort = Sort.by(asc? Sort.Direction.ASC : Sort.Direction.DESC,properties);
        Iterable<CoronaVaccine> listEntities = repo.findAll(sort);
        return listEntities;
    }

    @Override
    public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {

        PageRequest pageble = PageRequest.of(pageNo,pageSize,asc? Sort.Direction.ASC: Sort.Direction.DESC,properties);
        Page<CoronaVaccine> page =  repo.findAll(pageble);
        return page.getContent();
    }

    @Override
    public void fetchDetailsByPagination(int pageSize) {


        long count = repo.count(); //total record count output ::20

        long pageCount = count / pageSize;//deciding pageCount

        pageCount = count % pageSize == 0 ? pageCount:++pageCount ;

        for (int i=0; i<pageCount; i++){
            Pageable pageable = PageRequest.of(i,pageSize);
            Page<CoronaVaccine> page  = repo.findAll(pageable);
            page.getContent().forEach(System.out::println);
        }


    }
}
