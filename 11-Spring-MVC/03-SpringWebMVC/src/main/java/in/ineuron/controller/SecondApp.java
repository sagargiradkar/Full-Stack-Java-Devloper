package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondApp {

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView displayMsg(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Second Application...1");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/java")
    public String display(Model model){
        model.addAttribute("message","Spring Boot is awsome");
        return "index";
    }




}
