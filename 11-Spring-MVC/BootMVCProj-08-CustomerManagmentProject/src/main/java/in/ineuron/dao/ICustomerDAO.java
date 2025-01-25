package in.ineuron.dao;

import in.ineuron.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDAO extends CrudRepository<Customer,Integer> {
}
