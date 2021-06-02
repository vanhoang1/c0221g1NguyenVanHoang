package model.service.api;

import model.bean.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean save(Employee employee);
    Employee findById(int id);
    boolean update(int id, Employee employee);
    boolean  remove(int id);
    List<Employee> findByName(String search);
}
