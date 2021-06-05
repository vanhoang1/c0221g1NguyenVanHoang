package model.service.impl;

import model.bean.contract.Contract;
import model.repository.contract.ContractRepository;
import model.repository.customer.CustomerRepository;
import model.repository.employee.EmployeeRepository;
import model.repository.service.ServiceRepository;
import model.service.api.Service;

import java.util.List;

public class IContractService implements Service<Contract> {
   ContractRepository contractRepository = new ContractRepository();
    @Override
    public List<Contract> findAll() {
        return contractRepository.getAll();
    }

    @Override
    public boolean save(Contract contract) {
        return contractRepository.insert(contract);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.get(id);
    }

    @Override
    public boolean update(int id, Contract contract) {
        return contractRepository.update(id,contract);
    }

    @Override
    public boolean remove(int id) {
        return contractRepository.delete(id);
    }

    @Override
    public List<Contract> findByName(String search) {
        return contractRepository.search(search);
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
