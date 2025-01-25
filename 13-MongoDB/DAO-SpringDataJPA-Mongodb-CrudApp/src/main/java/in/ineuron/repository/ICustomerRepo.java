package in.ineuron.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.document.Custemer;

@Repository
public interface ICustomerRepo extends MongoRepository<Custemer, String> {

}
