package com.casestudy.model.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
    @EmbeddedId
    private ContractDetailKey id;
    @ManyToOne
    @MapsId("contractId")
    @JoinColumn(name = "contract_id")
    private Contract contract;
    @ManyToOne
    @MapsId("attachServiceId")
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;
    private Integer quantity;

}
