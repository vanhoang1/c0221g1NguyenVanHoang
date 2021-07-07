package com.casestudy.model.service.contractDetail;

import com.casestudy.model.entity.contract.AttachService;
import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.contract.ContractDetail;
import com.casestudy.model.repository.contract.IAttachServiceRepository;
import com.casestudy.model.repository.contract.IContractDetailRepository;
import com.casestudy.model.repository.contract.IContractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {
    private final IAttachServiceRepository attachServiceRepository;
    private final IContractRepository contractRepository;
    private final IContractDetailRepository contractDetailRepository;

    public ContractDetailService(IAttachServiceRepository attachServiceRepository, IContractRepository contractRepository, IContractDetailRepository contractDetailRepository) {
        this.attachServiceRepository = attachServiceRepository;
        this.contractRepository = contractRepository;
        this.contractDetailRepository = contractDetailRepository;
    }

    @Override
    public Iterable<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Iterable<Contract> findAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<ContractDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<ContractDetail> findAllNormal() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
