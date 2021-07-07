package com.casestudy.model.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "chi_tiet_hop_dong", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "u_hd_dvdk", columnNames = { "id_hop_dong", "id_dich_vu_di_kem" }) })

public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chi_tiet_hop_dong")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_hop_dong")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "id_dich_vu_di_kem")
    private AttachService attachService;
    @Column(name = "so_luong")
    private Integer quantity;

}
