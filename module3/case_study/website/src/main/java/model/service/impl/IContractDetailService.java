package model.service.impl;

import model.bean.contract.ContractDetail;
import model.repository.contract.AttachServiceRepository;
import model.repository.contract.ContractDetailRepository;
import model.repository.contract.ContractRepository;
import model.service.api.Service;

import java.util.List;
import java.util.Map;

public class IContractDetailService implements Service<ContractDetail> {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.getAll();
    }

    @Override
    public Map<String,String> save(ContractDetail contractDetail) {
        Map<String,String> map= findErr(contractDetail);
        if(map.isEmpty())contractDetailRepository.insert(contractDetail);
        return map;
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.get(id);
    }

    @Override
    public Map<String,String> update(int id, ContractDetail contractDetail) {
        if(findErr(contractDetail).isEmpty()) contractDetailRepository.update(id,contractDetail);
        return null;
    }

    @Override
    public boolean remove(int id) {
        return contractDetailRepository.delete(id);
    }

    @Override
    public List<ContractDetail> findByName(String search) {
        return contractDetailRepository.search(search);
    }

    @Override
    public Map<String,String> findErr(ContractDetail contractDetail) {
        return null;
    }


    public AttachServiceRepository attachServiceRepository(){
        return contractDetailRepository.getAttachServiceRepository();
     }

     public ContractRepository contractRepository (){
        return  contractDetailRepository.getContractRepository();
     }

}
