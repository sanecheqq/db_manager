package webapp_java.mvc.service;

import webapp_java.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee (Employee employee);

    Employee getEmployee (int id);

    void deleteEmployee (int id);
}
