package ineuron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {
    @GetMapping("/msg")
    public String wishMessage(){
        String msg = " Good Evening";
        return msg;
    }
}
