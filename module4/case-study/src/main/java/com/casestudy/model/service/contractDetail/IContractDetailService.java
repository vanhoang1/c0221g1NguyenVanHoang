package com.casestudy.model.service.contractDetail;

import com.casestudy.model.entity.contract.AttachService;
import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.contract.ContractDetail;
import com.casestudy.model.service.IGeneralService;

public interface IContractDetailService extends IGeneralService<ContractDetail> {
    Iterable<AttachService> findAllAttachService();
    Iterable<Contract> findAllContract();
}
