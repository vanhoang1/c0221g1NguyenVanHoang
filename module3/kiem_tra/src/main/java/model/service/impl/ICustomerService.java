package model.service.impl;

import model.bean.customer.Customer;
import model.repository.BaseRepository;
import model.repository.customer.CustomerRepository;
import model.service.api.Service;
import model.service.common.Validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICustomerService implements Service<Customer> {
    BaseRepository<Customer> customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }

    @Override
    public List<String> save(Customer customer) {
        List<String> err = findErr(customer);
        if (err.isEmpty()) customerRepository.insert(customer);
        return err;
    }

    public List<String> findErr(Customer customer) {
        List<String > err = new ArrayList<>();
        if (!Validate.checkPhoneNumber(customer.getSoDT()))
            err.add( "Wrong phone number format . Example: 090XXXXXXX <br>");
        if (!Validate.checkEmail(customer.getEmail()))
            err.add( "Wrong phone number format .Example:  abcd@xyz.com.vn <br>");
        if (!Validate.checkCustomerId(customer.getMaKhachHang()))
            err.add( "Wrong ID Customer format .Example:  KH-1234 <br>");
        if (err.isEmpty()) customerRepository.insert(customer);
        return err;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.get(id);
    }

    @Override
    public List<String> update(int id, Customer customer) {
        List<String> err = findErr(customer);
        if (err.isEmpty()) customerRepository.update(id, customer);
        return err;
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
