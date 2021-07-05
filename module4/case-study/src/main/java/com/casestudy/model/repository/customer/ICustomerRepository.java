package com.casestudy.model.repository.customer;

import com.casestudy.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query( value="select * from khach_hang kh where kh.co=1",nativeQuery=true)
    Iterable<Customer> findAllCustomer();

    @Query( value="UPDATE case_study.khach_hang t SET t.co = false WHERE t.id_khach_hang = :id",nativeQuery=true)
    void deleteCustomer(@Param("id") Long id);


}
