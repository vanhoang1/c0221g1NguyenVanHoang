package model.service.impl;

import model.bean.contract.Contract;
import model.repository.contract.ContractRepository;
import model.repository.customer.CustomerRepository;
import model.repository.employee.EmployeeRepository;
import model.repository.service.ServiceRepository;
import model.service.api.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IContractService implements Service<Contract> {
   ContractRepository contractRepository = new ContractRepository();
    @Override
    public List<Contract> findAll() {
        return contractRepository.getAll();
    }

    @Override
    public Map<String,String>  save(Contract contract)  {
        Map<String,String> map= findErr(contract);
        if(map.isEmpty())   contractRepository.insert(contract);
      return map;
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.get(id);
    }

    @Override
    public Map<String,String>  update(int id, Contract contract) {
        Map<String,String> map= findErr(contract);
        if(map.isEmpty()) contractRepository.update(id,contract);
        return map;
    }

    @Override
    public boolean remove(int id) {
        return contractRepository.delete(id);
    }

    @Override
    public List<Contract> findByName(String search) {
        return contractRepository.search(search);
    }

    @Override
    public  Map<String,String>  findErr(Contract contract) {
        Map<String,String> map = new HashMap<>();
        if(contract.getTotalMoney()<0)map.put("money","Total amount must be positive ");
        if(contract.getDeposit()<0)map.put("deposit","Deposit must be positive ");
        return map;
    }

    public EmployeeRepository employeeRepository (){
        return contractRepository.getEmployeeRepository();
   }
   public CustomerRepository customerRepository(){
        return  contractRepository.getCustomerRepository();
   }
   public ServiceRepository serviceRepository (){
        return contractRepository.getServiceRepository();
   }
}
