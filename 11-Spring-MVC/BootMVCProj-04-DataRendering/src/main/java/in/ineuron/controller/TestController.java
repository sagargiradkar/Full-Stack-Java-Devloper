package in.ineuron.controller;

import in.ineuron.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class TestController {

    @GetMapping
    public String showHome(){
        return "home";
    }

    @GetMapping("/report")
    public String showReport(Map<String, Object> model) {
      /*  // Adding simple data types (String, Integer, etc.)
        model.put("name", "Kohli");
        model.put("age", 49);
        model.put("address", "RCB");

        // Adding an array (String[])
        String[] countryName = new String[]{"IND", "USA", "UK"};
        model.put("countryName", countryName);

        // Adding a List (List<String>)
        List<String> countriesList = new ArrayList<>();
        countriesList.add("IND");
        countriesList.add("USA");
        countriesList.add("UK");
        model.put("countriesList", countriesList);

        // Adding a Set (Set<String>)
        Set<String> countriesSet = new HashSet<>();
        countriesSet.add("IND");
        countriesSet.add("USA");
        countriesSet.add("UK");
        model.put("countriesSet", countriesSet);

        // Adding a Map (Map<String, String>)
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("IND", "New Delhi");
        countryCapitalMap.put("USA", "Washington, D.C.");
        countryCapitalMap.put("UK", "London");
        model.put("countryCapitalMap", countryCapitalMap);

        // Adding other data types
        model.put("isActive", true);  // Boolean value
        model.put("pi", 3.14159);  // Double value
        model.put("longNumber", 123456789L);  // Long value
        model.put("charValue", 'A');  // Char value
*/
        List<Employee> empList = List.of(new Employee(10,"sachin","batsman",2234.45),
                new Employee(7,"dhoni","keeper",234.5),
                new Employee(18,"Kohali","batsman",2342.45));

        model.put("empList",empList);

        return "show_report";  // Returning the Thymeleaf template view name
    }
}
