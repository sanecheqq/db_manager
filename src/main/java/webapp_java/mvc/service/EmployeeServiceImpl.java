package webapp_java.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp_java.hibernate.entity.Employee;
import webapp_java.hibernate.dao.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    @Override
    public List<Employee> getAllEmployees () {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void saveEmployee (Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee (int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void deleteEmployee (int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Autowired
    public void setEmployeeDAO (EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


}
