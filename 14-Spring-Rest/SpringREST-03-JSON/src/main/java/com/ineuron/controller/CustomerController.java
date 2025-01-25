package com.ineuron.controller;

import com.ineuron.model.Company;
import com.ineuron.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/report/{id}")
    public ResponseEntity<Customer> showAllCustomer(@PathVariable Integer id){

        System.out.println("Customer data for the id :: "+id);

        Customer customer = new Customer();
        customer.setCno(id);
        customer.setCname("sachin");
        customer.setBillAmount(54.5f);
        customer.setFavColor(new String[]{"IND","MI","ASia"});
        customer.setStudies(List.of(
                "10th","12th","Engineering"
        ));
        customer.setPhoneNumbers(Set.of(3434234423L,243243243L));
        customer.setIdDetails(Map.of("Adhar",638746783648L));
        customer.setCompany(new Company("MI","IPL","Mmbai",45));
        ResponseEntity<Customer> entity = new ResponseEntity<>(customer, HttpStatus.OK);
        return entity;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        Integer id = 10;
        String body = "customer registered with the id ::"+id;
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

}
