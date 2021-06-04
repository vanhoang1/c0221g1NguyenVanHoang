package model.service.impl;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.CustomerRepository;
import model.service.api.Service;

import java.util.List;

public class ICustomerService implements Service<Customer> {
    BaseRepository<Customer> customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.get(id);
    }

    @Override
    public boolean update(int id, Customer customer) {
        return customerRepository.update(id, customer);
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> findByName(String search) {
        return customerRepository.search(search);
    }
}
