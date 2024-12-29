package in.ineuron.controller;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmntService;
import in.ineuron.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "controller")
public class MainController {

    static {
        System.out.println("MainController.class file is loading ...");
    }

    public MainController(){
        System.out.println("MainController :: 0 param contructor called ....");
    }
    @Autowired
    private ICustomerMgmntService service;

    public String processCustomer(CustomerVO vo) throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerAddress(vo.getCustomerAddress());
        customerDTO.setCustomerName(vo.getCustomerName());
        customerDTO.setPamt(Float.parseFloat(vo.getPamt()));
        customerDTO.setRate(Float.parseFloat(vo.getRate()));
        customerDTO.setTime(Float.parseFloat(vo.getTime()));

        String result = service.calcuateSimpleInterest(customerDTO);

        return result;
    }

}