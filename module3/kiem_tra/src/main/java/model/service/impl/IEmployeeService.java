package model.service.impl;

import model.bean.exam.Employee;
import model.repository.employee.EmployeeRepository;
import model.service.api.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IEmployeeService implements Service<Employee> {
    EmployeeRepository employeeRepository= new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.getAll();
    }

    @Override
    public List<String> save(Employee employee) {
        List<String> list = findErr(employee);
        if(list.isEmpty())  employeeRepository.insert(employee);
        return list;
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.get(id);
    }

    @Override
    public List<String> update(int id, Employee employee) {
        List<String> list = findErr(employee);
        if(list.size() ==0)
            employeeRepository.update(id,employee);
        return list;
    }

    @Override
    public boolean remove(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public List<Employee> findByName(String search) {
        return null;
    }

    @Override
    public List<String> findErr(Employee employee) {
        List<String> list = new ArrayList<>();
        if(!(employee.getName().matches("^\\D+$"))) list.add("Names cannot contain numbers");
        int age=Calendar.getInstance().get(Calendar.YEAR)-employee.getBirthDay().toInstant().atZone(ZoneId.of("Asia/Tokyo")).toLocalDate().getYear();
        if(age<18)list.add("Employee age must be over 18 years old.");
        return list;
    }
}
