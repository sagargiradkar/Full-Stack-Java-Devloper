package in.ineuron.controller;

import in.ineuron.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class EmployeeController {

    @GetMapping("/saveEmployee")
    public String showHome(){
        return "employee_form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Map<String,Object> model,@ModelAttribute("employee") Employee employee) {
        // Save the employee (in a real app, save it to a database)
        model.put("message", "Employee saved successfully!");
        System.out.println(employee);
        model.put("employee", employee);
        return "employee_details";
    }
}
