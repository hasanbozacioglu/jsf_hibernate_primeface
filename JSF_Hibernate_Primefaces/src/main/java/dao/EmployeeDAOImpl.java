package dao;

import model.Employee;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee insertEmployee(Employee employee) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(employee);
        session.getTransaction().commit();
        return employee;
    }

    @Override
    public Employee findEmployee(int id) {
        Employee employee=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        employee=session.get(Employee.class,id);
        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employee = null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Employee ");
        employee=query.list();
        return employee;
    }

    @Override
    public void removeEmployee(int id) {
        Employee employee=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        employee=session.get(Employee.class,id);
        session.remove(employee);
        session.getTransaction().commit();

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        return employee;
    }
}
