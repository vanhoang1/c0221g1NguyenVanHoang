package com.casestudy.model.repository.employee;

import com.casestudy.model.entity.employee.Education;
import com.casestudy.model.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Long> {
}
