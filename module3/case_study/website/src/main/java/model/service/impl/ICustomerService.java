package model.service.impl;

import model.bean.customer.Customer;
import model.repository.BaseRepository;
import model.repository.customer.CustomerRepository;
import model.service.api.Service;
import model.service.common.Validate;

import java.util.List;

public class ICustomerService implements Service<Customer> {
    BaseRepository<Customer> customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }

    @Override
    public boolean save(Customer customer) throws Exception {
             if(!Validate.checkPhoneNumber(customer.getSoDT())) throw new Exception("Wrong phone number format . Example: 090XXXXXX");
             if(!Validate.checkEmail(customer.getEmail())) throw  new Exception("Wrong phone number format .Example:  abc@xyz.com.vn");
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
