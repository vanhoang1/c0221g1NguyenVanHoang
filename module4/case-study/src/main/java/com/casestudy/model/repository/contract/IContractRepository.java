package com.casestudy.model.repository.contract;

import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.contract.ContractDetail;
import com.casestudy.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
}
