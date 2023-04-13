package webapp_java.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webapp_java.hibernate.entity.Employee;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees () {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Employee> sessionQuery = currentSession.createQuery("from Employee ", Employee.class);
        return sessionQuery.getResultList();
    }

    @Override
    @Transactional
    public void saveEmployee (Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee (int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Employee.class, id);
    }

    @Override
    @Transactional
    public void deleteEmployee (int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee employee = currentSession.get(Employee.class, id);
        currentSession.remove(employee);
    }
}
