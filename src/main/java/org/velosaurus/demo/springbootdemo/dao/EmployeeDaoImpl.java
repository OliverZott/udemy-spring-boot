package org.velosaurus.demo.springbootdemo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.velosaurus.demo.springbootdemo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    // automatically created by spring; here it's just injected
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // @Transactional moved to service
    // Transactional: no need to use "start" or "commit" transactions
    @Override
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        // if id=0: save, else: update
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery(
                "delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
