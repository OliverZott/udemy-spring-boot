package org.velosaurus.demo.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.velosaurus.demo.springbootdemo.dao.EmployeeDao;
import org.velosaurus.demo.springbootdemo.entity.Employee;

import java.util.List;

// To detect beans automatically,  Spring uses classpath scanning annotations
// @Service, @Repository, ...
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }
}
