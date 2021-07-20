package com.casestudy.model.service.employee;

import com.casestudy.model.entity.account.AppUser;
import com.casestudy.model.entity.employee.Division;
import com.casestudy.model.entity.employee.Education;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.employee.Position;
import com.casestudy.model.repository.employee.IDivisionRepository;
import com.casestudy.model.repository.employee.IEducationRepository;
import com.casestudy.model.repository.employee.IEmployeeRepository;
import com.casestudy.model.repository.employee.IPositionRepository;
import com.casestudy.model.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final IDivisionRepository divisionRepository;
    private final IPositionRepository positionRepository;
    private  final IEducationRepository educationRepository;
    private final IEmployeeRepository employeeRepository;
    private final IUserRepository userRepository;
    @Autowired
    public EmployeeService(IDivisionRepository divisionRepository, IPositionRepository positionRepository, IEducationRepository educationRepository, IEmployeeRepository employeeRepository, IUserRepository userRepository) {
        this.divisionRepository = divisionRepository;
        this.positionRepository = positionRepository;
        this.educationRepository = educationRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public Iterable<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Iterable<Education> findAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public Iterable<AppUser> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Employee findEmployeeByIdAppUser(Long id) {
        return employeeRepository.findEmployeeByIdAppUser(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable,String keyword) {
        return employeeRepository.findAllEmployee(pageable,'%'+keyword+'%');
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Iterable<Employee> findAllNormal() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteEmployee(id);
    }
}
