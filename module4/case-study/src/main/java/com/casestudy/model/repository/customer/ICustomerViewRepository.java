package com.casestudy.model.repository.customer;

import com.casestudy.model.entity.customer.CustomerView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerViewRepository extends JpaRepository<CustomerView, Long> {
    @Query(value="select * from khach_hang_view khv where khv.ho_ten like :keyword  or khv.ten_dich_vu_di_kem like :keyword",nativeQuery= true)
    Page<CustomerView> findAllByAttachServiceNameContainingOrCustomerNameContaining(Pageable pageable,@Param("keyword") String keyword);
}
