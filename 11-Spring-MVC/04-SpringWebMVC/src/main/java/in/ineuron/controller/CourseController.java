package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/course")
    public String getCourse(Model model){
        model.addAttribute("cid","65");
        model.addAttribute("cname","JAVA");
        model.addAttribute("cost","2345");
        return "course";
    }
}
