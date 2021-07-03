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
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private Set<Services> services;
}
