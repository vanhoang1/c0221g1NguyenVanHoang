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
@Table(name="vi_tri")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vi_tri")
    private Long id;
    @Column(name = "ten_vi_tri")
    private String name;
    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private Set<Employee> employees;

}
