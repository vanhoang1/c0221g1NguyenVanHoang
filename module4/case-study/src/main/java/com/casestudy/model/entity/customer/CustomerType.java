package com.casestudy.model.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany(mappedBy = "customerType")
    @JsonBackReference
    Set<Customer> customers;
}
