package model.service.impl;

import model.bean.ContractDetail;
import model.repository.AttachServiceRepository;
import model.repository.ContractDetailRepository;
import model.repository.ContractRepository;
import model.service.api.Service;

import java.util.List;

public class IContractDetailService implements Service<ContractDetail> {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.getAll();
    }

    @Override
    public boolean save(ContractDetail contractDetail) {
        return contractDetailRepository.insert(contractDetail);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.get(id);
    }

    @Override
    public boolean update(int id, ContractDetail contractDetail) {
        return contractDetailRepository.update(id,contractDetail);
    }

    @Override
    public boolean remove(int id) {
        return contractDetailRepository.delete(id);
    }

    @Override
    public List<ContractDetail> findByName(String search) {
        return contractDetailRepository.search(search);
    }
     public AttachServiceRepository attachServiceRepository(){
        return contractDetailRepository.getAttachServiceRepository();
     }

     public ContractRepository contractRepository (){
        return  contractDetailRepository.getContractRepository();
     }

}
