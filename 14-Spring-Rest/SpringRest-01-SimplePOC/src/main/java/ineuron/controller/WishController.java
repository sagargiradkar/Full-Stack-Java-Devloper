package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class WishController {

    @GetMapping("/msg")
    public String generateWishMessage(){
            String msg = "Welcome to REST full Services from ineuron";
            return msg;
    }
}
