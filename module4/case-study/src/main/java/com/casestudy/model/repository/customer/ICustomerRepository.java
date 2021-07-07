package com.casestudy.model.repository.customer;

import com.casestudy.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query( value="select * from khach_hang kh where kh.co=1 and kh.ho_ten like :keyword ",nativeQuery=true)
    Page<Customer> findAllCustomer(Pageable pageable,String keyword);

    @Transactional
    @Modifying
    @Query( value="UPDATE khach_hang k SET k.co = 0 WHERE k.id_khach_hang = :id",nativeQuery=true)
    int deleteCustomer(@Param(value="id") Long id);


}
