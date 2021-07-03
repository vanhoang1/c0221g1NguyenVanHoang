package com.casestudy.model.entity.contract;

import com.casestudy.model.entity.customer.Customer;
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
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attachName;
    private Double attachCost;
    private Integer attachUnit;
    private String status;

    @OneToMany(mappedBy = "attachService")
    @JsonBackReference
    Set<ContractDetail> contractDetails;

}
