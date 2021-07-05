package com.casestudy.model.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chi_tiet_hop_dong")
public class ContractDetail {
    @EmbeddedId
    private ContractDetailKey id;
    @ManyToOne
    @MapsId("contractId")
    @JoinColumn(name = "id_hop_dong")
    private Contract contract;
    @ManyToOne
    @MapsId("attachServiceId")
    @JoinColumn(name = "id_dich_vu_di_kem")
    private AttachService attachService;
    @Column(name = "so_luong")
    private Integer quantity;

}
