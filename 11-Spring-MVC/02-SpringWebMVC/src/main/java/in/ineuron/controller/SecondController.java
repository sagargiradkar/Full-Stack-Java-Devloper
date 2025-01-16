package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/welcome")
    public String someWork(Model model){
        model.addAttribute("work","Second Controller");
        return "index";
    }

    @GetMapping("/java")
    public String someWorkOther(Model model){
        model.addAttribute("message","Second Controller 2nd message");
        return "index";
    }

    @GetMapping("/get-name")
    public String getNames(Model model){
        model.addAttribute("message","MY NAME IS SAGAR");
        return "index";
    }


    @GetMapping
    public String getAddrs(Model model){
        model.addAttribute("message","BENGULURU");
        return "index";
    }
}
