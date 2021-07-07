package com.casestudy.model.service.contract;

import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.service.Services;
import com.casestudy.model.repository.contract.IContractRepository;
import com.casestudy.model.repository.customer.ICustomerRepository;
import com.casestudy.model.repository.employee.IEmployeeRepository;
import com.casestudy.model.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractService implements IContractService {
    private final ICustomerRepository customerRepository;
    private final IEmployeeRepository employeeRepository;
    private final ServiceRepository serviceRepository;
    private final IContractRepository contractRepository;

    @Autowired
    public ContractService(ICustomerRepository customerRepository, IEmployeeRepository employeeRepository, ServiceRepository serviceRepository, IContractRepository contractRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public Iterable<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Iterable<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Iterable<Services> findAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Contract> findAllNormal() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {

    }
}
