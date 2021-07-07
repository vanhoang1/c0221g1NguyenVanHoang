package com.casestudy.model.service.customer;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.customer.CustomerType;
import com.casestudy.model.repository.customer.ICustomerRepository;
import com.casestudy.model.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository;

    private final ICustomerTypeRepository customerTypeRepository;
    @Autowired
    public CustomerService(ICustomerRepository customerRepository, ICustomerTypeRepository customerTypeRepository) {
        this.customerRepository = customerRepository;
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public Iterable<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable,String keyword) {
        return customerRepository.findAllCustomer(pageable,'%'+keyword+'%');
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Iterable<Customer> findAllNormal() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteCustomer(id);
    }
}
