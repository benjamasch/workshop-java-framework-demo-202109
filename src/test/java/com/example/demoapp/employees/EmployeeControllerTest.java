package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listEmployee() {
        // Act
        EmployeeRespons[] results = restTemplate.getForObject("/employees", EmployeeResponse[].class);

        // Assert
        assertEquals(2, results.length);
        assertEquals(1, results[0].getId());
        assertEquals("benjamas", results[0].getName());
    }

    @Test
    public void getEmployeeById() {
        // Act
        EmployeeRespons results = restTemplate.getForObject("/employees/1", EmployeeResponse.class);
        // Assert
        assertEquals(1, results[0].getId());
        assertEquals("benjamas", results[0].getName());
    }
}