package model.service.impl;

import model.bean.Customer;
import model.service.api.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICustomerService implements CustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Nhung", "1998-03-02", "Female", 12312332, 1232345,"1", "abc@gmail.com", null));
        customers.put(2, new Customer(2, "Hung", "1998-04-03", "Male", 12312332, 1232345, "2","abc@gmail.com", null));
        customers.put(3, new Customer(3, "Thao", "1996-05-03", "Female", 12312332, 1232345,"3", "abc@gmail.com", null));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
