package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.api.EmployeeService;

import java.util.List;

public class IEmployeeService implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Employee employee) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public List<Employee> findByName(String search) {
        return null;
    }
}
