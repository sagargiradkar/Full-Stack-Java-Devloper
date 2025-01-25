package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.document.Custemer;
import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgnmtService {
    String registerCustomer(CustomerDTO dto);
    List<Custemer> getAllCustomers();
    String updateCustomer(String id, CustomerDTO dto);
    String deleteCustomerById(String id);
}
