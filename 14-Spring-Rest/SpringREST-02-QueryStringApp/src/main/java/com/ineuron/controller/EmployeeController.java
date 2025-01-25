package com.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // GET: Read Employee
    @GetMapping("/read")
    public ResponseEntity<String> getEmployee(
            @RequestParam Integer id,
            @RequestParam String name) {
        System.out.println("Name ::" + name);
        String body = null;
        if (id == 7 && name.equals("dhoni")) {
            body = "CSK TEAM";
        } else if (id == 18 && name.equals("kohali")) {
            body = "RCB Team";
        } else {
            body = id + " " + name + " - No Team";
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // POST: Add a new Employee
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(
            @RequestBody String employeeDetails) {
        System.out.println("Employee Details: " + employeeDetails);
        return new ResponseEntity<>("Employee created successfully: " + employeeDetails, HttpStatus.CREATED);
    }

    // PUT: Update Employee
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(
            @RequestParam Integer id,
            @RequestBody String updatedDetails) {
        System.out.println("Updating Employee with ID: " + id);
        return new ResponseEntity<>("Employee with ID " + id + " updated with details: " + updatedDetails, HttpStatus.OK);
    }

    // PATCH: Partially Update Employee
    @PatchMapping("/patch")
    public ResponseEntity<String> patchEmployee(
            @RequestParam Integer id,
            @RequestParam String attribute,
            @RequestParam String value) {
        System.out.println("Patching Employee ID: " + id);
        return new ResponseEntity<>("Employee ID " + id + " updated: " + attribute + " = " + value, HttpStatus.OK);
    }

    // DELETE: Delete Employee
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer id) {
        System.out.println("Deleting Employee ID: " + id);
        return new ResponseEntity<>("Employee with ID " + id + " deleted successfully.", HttpStatus.OK);
    }
}
