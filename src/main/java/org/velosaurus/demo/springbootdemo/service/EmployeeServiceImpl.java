package org.velosaurus.demo.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.velosaurus.demo.springbootdemo.dao.EmployeeDao;
import org.velosaurus.demo.springbootdemo.entity.Employee;

import javax.transaction.Transactional;
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
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    // Not implemented in this version
    @Override
    public List<Employee> getEmployees(int page, int size) {
        return null;
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        this.employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
