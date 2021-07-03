package com.casestudy.model.entity.contract;



import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.service.Services;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double deposit;
    private Double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonManagedReference
    private Services service;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    Set<ContractDetail> contractDetails;
}
