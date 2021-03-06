package com.casestudy.model.repository.employee;


import com.casestudy.model.entity.employee.Division;
import com.casestudy.model.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository  extends JpaRepository<Division, Long> {
}
