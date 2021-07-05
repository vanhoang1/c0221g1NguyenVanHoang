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
@Table(name="dich_vu_di_kem")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dich_vu_di_kem")
    private Long id;
    @Column(name = "ten_dich_vu_di_kem")
    private String attachName;
    @Column(name = "gia")
    private Double attachCost;
    @Column(name = "don_vi")
    private Integer attachUnit;
    @Column(name = "trang_thai_kha_dung")
    private String status;

    @OneToMany(mappedBy = "attachService")
    @JsonBackReference
    Set<ContractDetail> contractDetails;

}
