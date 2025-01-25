package in.ineuron.service;

import in.ineuron.dao.ICustomerDAO;
import in.ineuron.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDAO repo;
    @Override
    public List<Customer> getCustomer() {

        return (List<Customer>) repo.findAll();
    }
}
