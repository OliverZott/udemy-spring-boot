package org.velosaurus.demo.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.velosaurus.demo.springbootdemo.dao.EmployeeRepository;
import org.velosaurus.demo.springbootdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceRepoImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceRepoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // currently unused
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
    }

    @Override
    public List<Employee> getEmployees(int page, int size) {
        var employees = employeeRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "lastName")));
        return employees.getContent();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        Employee employee = null;
        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
