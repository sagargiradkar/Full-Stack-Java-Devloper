package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MoreQueryParams {

    @GetMapping("/processPath/{param1}/{param2}/{param3}")
    public String handlePath(
            @PathVariable String param1,
            @PathVariable String param2,
            @PathVariable Integer param3,
            Model model) {
        // Add path parameters to the model
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        model.addAttribute("param3", param3);

        // Return the JSP page name
        return "result1";
    }
}
