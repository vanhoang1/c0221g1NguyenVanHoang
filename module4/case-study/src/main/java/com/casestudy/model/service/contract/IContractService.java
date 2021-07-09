package com.casestudy.model.service.contract;

import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.service.Services;
import com.casestudy.model.service.IGeneralService;

public interface IContractService extends IGeneralService<Contract> {
    Iterable<Customer> findAllCustomer();
    Iterable<Employee> findAllEmployee();
    Iterable<Services> findAllService();
    Iterable<Double> findTotalMoney();
}
