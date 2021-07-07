package com.casestudy.model.entity.dto;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.service.Services;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private Long id;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
    @Min(0)
    private Double deposit;
    @Min(0)
    private Double totalMoney;
    @NotNull
    private Employee employee;
    @NotNull
    private Customer customer;
    @NotNull
    private Services service;

}
