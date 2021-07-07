package com.casestudy.model.entity.dto;

import com.casestudy.model.entity.service.RentType;
import com.casestudy.model.entity.service.ServiceType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private Long id;
    @NotBlank
    private String name;
    @Min(0)
    private Double areaOfUse;
    @Min(0)
    private Integer numberOfFloors;
    @Min(0)
    private Integer maxNumOfPeople;
    @Min(0)
    private Integer rentalCosts;

    private RentType rentType;

    private ServiceType serviceType;

    private String status;
    @Pattern(regexp = "^(DV-)\\d{4}$",message = "Invalid Service Id , DV-XXXX")
    private String maDichVu;
}
