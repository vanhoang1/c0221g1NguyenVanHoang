package com.casestudy.model.repository.contract;

import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.contract.ContractDetail;
import com.casestudy.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value="select (datediff(h.ngay_ket_thuc, h.ngay_lam_hop_dong)* dv.chi_phi_thue) - h.tien_dat_coc as total_money from hop_dong h JOIN dich_vu dv on h.id_dich_vu = dv.id_dich_vu" , nativeQuery=true)
    Iterable<Double> findTotalMoney();
}
