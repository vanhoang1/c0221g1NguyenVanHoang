package com.casestudy.model.entity.service;


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
@Table(name="loai_dich_vu")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai_dich_vu")
    private Long id;
    @Column(name = "ten_loai_dich_vu")
    private String name;
    @OneToMany(mappedBy = "serviceType")
    @JsonBackReference
    private Set<Services> services;
}
