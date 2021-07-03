package com.casestudy.model.entity.service;

import com.casestudy.model.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "area_of_use")
    private Double areaOfUse;
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;
    @Column(name = "max_num_of_people")
    private Integer maxNumOfPeople;
    @Column(name = "rental_costs")
    private Integer rentalCosts;
    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    @JsonManagedReference
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    @JsonManagedReference
    private ServiceType serviceType;
    private String status;
    private String maDichVu;

    @OneToMany(mappedBy = "service")
    @JsonBackReference
    Set<Contract> contracts;
}
