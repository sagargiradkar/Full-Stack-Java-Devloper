package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryController {

    @GetMapping("/service")
    public String displayQueryParam(@RequestParam("name") String str , Model model){
        String mesg = str.concat(" Welcome to iNeuron !").toUpperCase();
        model.addAttribute("query",mesg);
        return "index";
    }
}
