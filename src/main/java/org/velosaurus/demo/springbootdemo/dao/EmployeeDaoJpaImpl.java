/*
 * Repository/DAO version 2:
 * Using EntityManager and standard JPA API
 *
 * JPA uses JPQL (Java Persistence Query Language)
 *   - https://www.tutorialspoint.com/jpa/jpa_jpql.htm
 *
 * Advantage:
 * - not locked to vendor implementation
 * - portable, flexible code
 * - it's possible to switch vendor
 */

package org.velosaurus.demo.springbootdemo.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.velosaurus.demo.springbootdemo.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Primary
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private final EntityManager entityManager;

    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create query
        Query query = entityManager.createQuery("from Employee");

        // execute query and get list
        List<Employee> employees = query.getResultList();

        // return result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

        // save or update (if id==0) employee
        Employee dbEmployee = entityManager.merge(employee);

        // update employee with id from db
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        //delete object with primary key
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
