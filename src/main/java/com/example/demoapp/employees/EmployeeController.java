package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee() {
        EmployeeResponse employee001 = new EmployeeResponse();
        employee001.setId(1);
        employee001.setName("benjamas");
        EmployeeResponse employee002 = new EmployeeResponse();
        employee001.setId(2);
        employee001.setName("benjamas 2");
        return new EmployeeResponse[]{employee001, employee002};
    }
}
