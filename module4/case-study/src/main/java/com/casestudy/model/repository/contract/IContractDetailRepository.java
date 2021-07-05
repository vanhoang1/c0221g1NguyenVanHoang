package com.casestudy.model.repository.contract;

import com.casestudy.model.entity.contract.ContractDetail;
import com.casestudy.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {
}
