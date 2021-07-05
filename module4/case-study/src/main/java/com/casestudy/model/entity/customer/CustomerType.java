package com.casestudy.model.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loai_khach")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai_khach")
    Long id;
    @Column(name = "ten_loai_khach")
    String name;
    @OneToMany(mappedBy = "customerType")
    @JsonBackReference
    Set<Customer> customers;
}
