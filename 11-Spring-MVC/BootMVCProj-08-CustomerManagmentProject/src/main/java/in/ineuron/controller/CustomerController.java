package in.ineuron.controller;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/list")
    public String listCustomers(Map<String,Object> model){
        System.out.println("Implementation class is :: "+service.getClass().getName());

        List<Customer> customers = service.getCustomer();
        customers.forEach(System.out::println);
        model.put("customers",customers);
        return "list-customer";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Map<String,Object> model){

        Customer customers = new Customer();
        model.put("customers",customers);
        return "customer-form";
    }

    public String saveCustomer(){
        return "redirect:/customer/list";
    }
}
