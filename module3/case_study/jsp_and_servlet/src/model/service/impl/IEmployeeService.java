package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.api.Service;

import java.util.List;

public class IEmployeeService implements Service<Employee> {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.getAll();
    }

    @Override
    public boolean save(Employee employee) {
        return employeeRepository.insert(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.get(id);
    }

    @Override
    public boolean update(int id, Employee employee) {
        return employeeRepository.update(id,employee);
    }

    @Override
    public boolean remove(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public List<Employee> findByName(String search) {
        return employeeRepository.search(search);
    }
}
