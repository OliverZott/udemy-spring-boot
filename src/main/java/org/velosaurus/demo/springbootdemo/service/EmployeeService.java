package org.velosaurus.demo.springbootdemo.service;

import org.velosaurus.demo.springbootdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
}
