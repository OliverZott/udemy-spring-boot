package org.velosaurus.demo.springbootdemo.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    private final EmployeeService employeeService;

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
    @JsonView(Employee.class)
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException(String.format("Employee with id=%d not found", employeeId));
        }

        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // 0 to create, 1 to update
        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("No employee with id " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee with id " + employeeId;
    }


}
