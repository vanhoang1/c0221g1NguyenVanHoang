package com.casestudy.model.repository.employee;

import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long> {
}
