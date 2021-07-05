package com.casestudy.model.service.employee;

import com.casestudy.model.entity.employee.Division;
import com.casestudy.model.entity.employee.Education;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.employee.Position;
import com.casestudy.model.repository.employee.IDivisionRepository;
import com.casestudy.model.repository.employee.IEducationRepository;
import com.casestudy.model.repository.employee.IEmployeeRepository;
import com.casestudy.model.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final IDivisionRepository divisionRepository;
    private final IPositionRepository positionRepository;
    private  final IEducationRepository educationRepository;
    private final IEmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(IDivisionRepository divisionRepository, IPositionRepository positionRepository, IEducationRepository educationRepository, IEmployeeRepository employeeRepository) {
        this.divisionRepository = divisionRepository;
        this.positionRepository = positionRepository;
        this.educationRepository = educationRepository;
        this.employeeRepository = employeeRepository;
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
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }
}
