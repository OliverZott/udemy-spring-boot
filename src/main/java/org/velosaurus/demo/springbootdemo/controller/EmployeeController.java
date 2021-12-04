package org.velosaurus.demo.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.velosaurus.demo.springbootdemo.entity.Employee;
import org.velosaurus.demo.springbootdemo.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceRepoImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "form-for-add";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);
        return "form-for-add";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        // Post/Redirect/Get Pattern implementation
        return "redirect:/employees/list";
    }

    // When you are building MVC browser-based applications, you can only use @GetMapping and @PostMapping.
    // If you are building REST applications, all the HTTP methods can be used.
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

}
