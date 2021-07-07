package com.casestudy.model.service.employee;

import com.casestudy.model.entity.account.AppUser;
import com.casestudy.model.entity.employee.Division;
import com.casestudy.model.entity.employee.Education;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.employee.Position;
import com.casestudy.model.service.IGeneralService;

public interface IEmployeeService extends IGeneralService<Employee> {
    Iterable<Division> findAllDivision();
    Iterable<Position> findAllPosition();
    Iterable<Education> findAllEducation();
    Iterable<AppUser> findAllUser();
}
