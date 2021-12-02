package org.velosaurus.demo.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.velosaurus.demo.springbootdemo.entity.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // all methods are implemented by interface!
}
