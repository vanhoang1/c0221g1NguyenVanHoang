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
@Table(name="trinh_do")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trinh_do")
    private Long id;
    @Column(name = "trinh_do")
    private String name;
    @OneToMany(mappedBy = "education")
    @JsonBackReference
    private Set<Employee> employees;
}
