package webapp_java.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webapp_java.hibernate.dao.EmployeeDAO;
import webapp_java.hibernate.entity.Employee;
import webapp_java.mvc.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees (Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);
        return "all-employees";
    }

    @RequestMapping("add-new-employee")
    public String addNewEmployee (Model model) {
        Employee employee = new Employee();
        model.addAttribute("newEmployee", employee);
        return "employee-info";
    }

    @RequestMapping("save-employee")
    public String saveEmployee (@Valid @ModelAttribute("newEmployee") Employee newEmployee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-info";
        }
        employeeService.saveEmployee(newEmployee);
        return "redirect:/";
    }

    @RequestMapping("update-employee")
    public String updateEmployee (@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("newEmployee", employee);
        return "employee-info";
    }

    @RequestMapping("delete-employee")
    public String deleteEmployee (@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @Autowired
    public void setEmployeeService (EmployeeDAO employeeService) {
        this.employeeService = employeeService;
    }
}
