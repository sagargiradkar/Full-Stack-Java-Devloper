package in.ineuron.controller;

import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVo;
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
    private IEmployeeService service;

    public EmployeeVo transferObject(EmployeeVo VO){


        service.calculateHike(dto);
        return null;
    }
    @Override
    public String toString() {
        return "MainController{" +
                "service=" + service +
                '}';
    }
}