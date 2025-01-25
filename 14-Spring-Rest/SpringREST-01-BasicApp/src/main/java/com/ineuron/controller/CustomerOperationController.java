package ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {

    @GetMapping("/report")
    public ResponseEntity<String> showCustomerReport(){
        return new ResponseEntity<String>("FREOM GET-SHOW ResponseMethod", HttpStatus.OK);
    }

    @PostMapping("/report")
    public ResponseEntity<String> registrationCustomoe(){
        return new ResponseEntity<String>("FREOM POST-SHOW registrationCustomoe", HttpStatus.OK);
    }

    @PatchMapping("/pmodify")
    public ResponseEntity<String> updateCustomerByNo(){
        return new ResponseEntity<String>("FREOM PATCH-SHOW updateCustomerByNo", HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updateCustomer(){
        return new ResponseEntity<String>("FREOM PUT-SHOW UpdateCustomer", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(){
        return new ResponseEntity<String>("FREOM DELETE-SHOW deleteCustomer", HttpStatus.OK);
    }
}
