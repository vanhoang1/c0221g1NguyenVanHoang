package com.casestudy.model.entity.employee;

import com.casestudy.model.entity.contract.Contract;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "position_id")
    @JsonManagedReference
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_id")
    @JsonManagedReference
    private Education education;
    @ManyToOne
    @JoinColumn(name = "division_id")
    @JsonManagedReference
    private Division division;
    private LocalDate birthDay;
    private String idCard;
    private Double salary;
    private String phone;
    private String address;
    private String email;
    private String username;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    Set<Contract> contracts;
}
