package org.velosaurus.demo.springbootdemo.service;

import org.velosaurus.demo.springbootdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    List<Employee> getEmployees(int page, int size);

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
