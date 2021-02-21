package org.velosaurus.demo.springbootdemo.dao;

import org.velosaurus.demo.springbootdemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
