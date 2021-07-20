package com.casestudy.model.repository.employee;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query( value="select * from nhan_vien nv where nv.co= 1 and nv.ho_ten like :keyword ",nativeQuery=true)
    Page<Employee> findAllEmployee(Pageable pageable, String keyword);

    @Transactional
    @Modifying
    @Query( value="UPDATE  nhan_vien nv SET nv.co = 0 WHERE nv.id_nhan_vien = :id",nativeQuery=true)
    int deleteEmployee(@Param(value="id") Long id);

    @Query( value="select * from nhan_vien nv where nv.id_tai_khoan = :id ",nativeQuery=true)
    Employee findEmployeeByIdAppUser(@Param(value="id") Long id);

}
