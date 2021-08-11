package com.backend.pharmacy_management.model.entity.bill_wholesale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill_wholesale")
public class BillWholesale {
    @Id
    @Column(name = "bill_wholesale_id")
    private Long billWholesaleId;
    private String code;
    private String invoiceDate;
    private String note;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "billWholesale")
    private Set<DrugOfBillWholesale> drugOfBillWholesaleSet;
}