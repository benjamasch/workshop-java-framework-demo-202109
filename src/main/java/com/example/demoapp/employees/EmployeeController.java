package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee() {
        EmployeeResponse employee001 = new EmployeeResponse();
        employee001.setId(1);
        employee001.setName("benjamas");
        EmployeeResponse employee002 = new EmployeeResponse();
        employee002.setId(2);
        employee002.setName("benjamas 2");
        return new EmployeeResponse[]{employee001, employee002};
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
//       Validate input
//       Claening data
        EmployeeResponse response = employeeService.getById(Integer.parseInt(id));
//        EmployeeResponse employee001 = new EmployeeResponse();
//        employee001.setId(Integer.parseInt(id));
//        employee001.setName("benjamas");
        return response;
    }
}
