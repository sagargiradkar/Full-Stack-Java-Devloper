package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DataBindingController {

    @GetMapping("/data")
    public String bindData(Map<String,Object> model, @RequestParam("sno") Integer sno,
                           @RequestParam("sname") String sname){
        System.out.println("SNO is :: "+sno);
        System.out.println("SNAME is :: "+sname);
        return "home";
    }
    @GetMapping("/data1")
    public String bindData1(Map<String,Object> model, @RequestParam("sno") Integer sno,
                           @RequestParam(required = false) String sname){
        System.out.println("SNO is :: "+sno);
        System.out.println("SNAME is :: "+sname);
        return "home";
    }
}
