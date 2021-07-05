package com.casestudy.model.service.customer;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.customer.CustomerType;
import com.casestudy.model.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<CustomerType> findAllCustomerType();
}
