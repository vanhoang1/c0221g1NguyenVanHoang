package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.api.CustomerService;

import java.util.List;

public class ICustomerService implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public boolean update(int id, Customer customer) {
        return customerRepository.updateCustomer(id, customer);
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> findByName(String search) {
        return customerRepository.findCustomer(search);
    }
}
