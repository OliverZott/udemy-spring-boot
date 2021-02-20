package org.velosaurus.demo.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.velosaurus.demo.springbootdemo.entity.Employee;
import org.velosaurus.demo.springbootdemo.service.EmployeeService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/hello")
    public String showExamplePage() {
        String time = ZonedDateTime.now(ZoneId.of("Europe/Vienna")).format(DateTimeFormatter.ISO_DATE_TIME);

        return "Hello, it's " + time + ". Alternative: " + LocalDateTime.now();
    }

    // Jackson does marshalling automatically?
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


}
