package com.casestudy.model.entity.customer;


import com.casestudy.model.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDay;
    private String idCard;
    private Integer gender;
    private String phone;
    private String maKhachHang;
    private String address;
    private String email;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    @JsonManagedReference
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    Set<Contract> contracts;
}
