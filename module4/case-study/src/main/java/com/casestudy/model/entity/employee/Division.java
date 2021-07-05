package com.casestudy.model.entity.employee;

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
@Table(name="bo_phan")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bo_phan")
    private Long id;
    @Column(name = "ten_bo_phan")
    private String name;
    @OneToMany(mappedBy = "division")
    @JsonBackReference
    private Set<Employee> employees;

}
