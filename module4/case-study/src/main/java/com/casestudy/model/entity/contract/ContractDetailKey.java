package com.casestudy.model.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ContractDetailKey implements Serializable {
    @Column(name = "contract_id")
    Long contractId;

    @Column(name = "attach_service_id")
    Long attachServiceId;
}
