package model.service.impl;

import model.bean.employee.Employee;
import model.repository.employee.EmployeeRepository;
import model.service.api.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IEmployeeService implements Service<Employee> {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.getAll();
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> map = findErr(employee);
        if (map.isEmpty()) employeeRepository.insert(employee);
        return map;
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.get(id);
    }

    @Override
    public Map<String, String> update(int id, Employee employee) {
        Map<String, String> map = findErr(employee);
        if (map.isEmpty()) employeeRepository.update(id,employee);
        return map;
    }

    @Override
    public boolean remove(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public List<Employee> findByName(String search) {
        return employeeRepository.search(search);
    }

    @Override
    public  Map<String, String> findErr(Employee employee) {
        Map<String, String> map = new HashMap<>();
        if(employee.getSalary()<0)map.put("salary","Salary must be positive");
        return map;
    }
}
