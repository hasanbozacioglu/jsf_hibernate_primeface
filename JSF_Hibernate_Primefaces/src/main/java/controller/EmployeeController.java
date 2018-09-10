package controller;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeController {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private List<Employee> employees = new ArrayList<Employee>();
    private List<Employee> selectedEmployees;

    public List<Employee> getSelectedEmployees() {
        return selectedEmployees;
    }

    public void setSelectedEmployees(List<Employee> selectedEmployees) {
        this.selectedEmployees = selectedEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @PostConstruct
    private void initEmploye() {
        employees = new EmployeeServiceImpl().findAllEmployees();
    }

    public void addEmployee() {
        EmployeeService employeeService = new EmployeeServiceImpl();
        if (id != 0) {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setSurname(surname);
            employee.setSalary(salary);
            employeeService.updateEmployee(employee);
            employees = employeeService.findAllEmployees();
        } else {
            Employee employee = new Employee(name, surname, salary);
            employeeService.insertEmployee(employee);
            employees = employeeService.findAllEmployees();
        }

    }

    public void clearForm(){
        this.id=0;
        this.name=null;
        this.surname=null;
        this.salary=0;
    }

    public void deleteEmployee(int id) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.removeEmployee(id);
        employees = employeeService.findAllEmployees();

    }

    public void deleteSelectedEmployees() {
        EmployeeService employeeService = new EmployeeServiceImpl();
        for (Employee e : selectedEmployees) {
            employeeService.removeEmployee(e.getId());
        }
        employees = employeeService.findAllEmployees();
    }

    public void selectedEmployee(int id) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.findEmployee(id);
        this.id=employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.salary = employee.getSalary();
    }
}
