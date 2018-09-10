package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee insertEmployee(Employee employee);

    public Employee findEmployee(int id);

    public List<Employee> findAllEmployees();

    public void removeEmployee(int id);

    public Employee updateEmployee(Employee employee);
}
