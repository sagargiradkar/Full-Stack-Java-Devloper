package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoreQueryParam {

    @GetMapping("/processQuery")
    public String handleQuery(
            @RequestParam(required = false) String param1,
            @RequestParam(required = false) String param2,
            @RequestParam(required = false) Integer param3,
            Model model) {
        // Add query parameters to the model
        model.addAttribute("param1", param1 != null ? param1 : "Not Provided");
        model.addAttribute("param2", param2 != null ? param2 : "Not Provided");
        model.addAttribute("param3", param3 != null ? param3 : "Not Provided");

        // Return the JSP page name
        return "result";
    }
}
