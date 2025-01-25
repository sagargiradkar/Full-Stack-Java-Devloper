package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import in.ineuron.document.Custemer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.repository.ICustomerRepo;

@Service("service")
public class CustomerMgmtServiceImpl implements ICustomerMgnmtService {

    @Autowired
    private ICustomerRepo repo;

    @Override
    public String registerCustomer(CustomerDTO dto) {
        System.out.println("Proxy class name is :: " + repo.getClass().getName());

        // Create a new Customer document instance
        Custemer customer = new Custemer();

        // Copy properties from DTO to document
        BeanUtils.copyProperties(dto, customer);

        // Save the document using the repository
        customer = repo.insert(customer);

        // Return a success message with the generated ID
        return "Document is saved with the id :: " + customer.getId();
    }

    @Override
    public List<Custemer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public String updateCustomer(String id, CustomerDTO dto) {
        // Fetch the customer by ID
        Optional<Custemer> optional = repo.findById(id);

        if (optional.isPresent()) {
            // Get the existing customer
            Custemer existingCustomer = optional.get();

            // Update fields from the DTO to the existing document
            BeanUtils.copyProperties(dto, existingCustomer);

            // Save the updated document
            repo.save(existingCustomer);

            return "Document is updated successfully for ID :: " + id;
        }
        return "Document with ID :: " + id + " not found.";
    }

    @Override
    public String deleteCustomerById(String id) {
        Optional<Custemer> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.delete(optional.get());
            return "Document is deleted successfully.";
        }
        return "Document with ID :: " + id + " not found.";
    }
}
