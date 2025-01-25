package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping
    public String showHome(){
        return "home";
    }


    /*
    @RequestMapping(value = "REPORT",method = RequestMethod.GET)
    public String showReport(Map<String,Object> map){
        System.out.println("Show Report");
        return "display";
    }
    @RequestMapping(value = "report",method = RequestMethod.GET)
    public String showReport1(Map<String,Object> map){
        System.out.println("Show Report1");
        return "display1";
    }
    */

    /*@GetMapping(value = {"report","report1","report2"})
    public String showReport(Map<String,Object> map){
        System.out.println("Show Report");
        return "display";
    }*/


    @GetMapping(value = {"report"})
    public String showReport(Map<String,Object> map){
        System.out.println("Show Report");
        return "display";
    }

    @PostMapping(value = {"report"})
    public String showReport1(Map<String,Object> map){
        System.out.println("Show Report");
        return "display";
    }
}
