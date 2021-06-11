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
    public Map<String, String> save(Customer customer) {
        Map<String, String> map = findErr(customer);
        if (map.isEmpty()) customerRepository.insert(customer);
        return map;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.get(id);
    }

    @Override
    public Map<String, String> update(int id, Customer customer) {
        Map<String, String> map = findErr(customer);
        if (map.isEmpty()) customerRepository.update(id, customer);
        return map;
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> findByName(String search) {
        return customerRepository.search(search);
    }

    @Override
    public Map<String, String> findErr(Customer customer) {
        Map<String, String> map = new HashMap<>();
        if (!Validate.checkPhoneNumber(customer.getSoDT()))
            map.put("phone", "Wrong phone number format . Example: 090XXXXXXX <br>");
        if (!Validate.checkEmail(customer.getEmail()))
            map.put("email", "Wrong phone number format .Example:  abcd@xyz.com.vn <br>");
        if (!Validate.checkCustomerId(customer.getMaKhachHang()))
            map.put("id", "Wrong ID Customer format .Example:  KH-1234 <br>");
        return map;
    }
}
