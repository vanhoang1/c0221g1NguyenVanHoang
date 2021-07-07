package com.casestudy.model.entity.dto;

import com.casestudy.model.entity.contract.AttachService;
import com.casestudy.model.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailDto {
    private Long id;

    private Contract contract;

    private AttachService attachService;
    @Min(0)
    private Integer quantity;
}
