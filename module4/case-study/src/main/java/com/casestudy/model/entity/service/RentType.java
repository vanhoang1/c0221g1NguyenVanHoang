package com.casestudy.model.entity.service;

import com.casestudy.model.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kieu_thue")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kieu_thue")
    private Long id;
    @Column(name = "ten_kieu_thue")
    private String name;
    @Column(name = "gia")
    private Double cost;
    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private Set<Services> services;
}
