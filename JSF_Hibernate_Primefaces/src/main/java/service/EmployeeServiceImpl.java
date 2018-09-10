package service;

import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAOImpl employeeDAOImpl;

    public EmployeeServiceImpl() {
        employeeDAOImpl = new EmployeeDAOImpl();
    }

    private EmployeeDAOImpl getEmployeeDAOImpl() {
        return employeeDAOImpl;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAOImpl.updateEmployee(employee);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeDAOImpl.insertEmployee(employee);
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeDAOImpl.findEmployee(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAOImpl.findAllEmployees();
    }

    @Override
    public void removeEmployee(int id) {
        employeeDAOImpl.removeEmployee(id);
    }

}
