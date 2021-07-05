package com.casestudy.model.entity.dto;

import com.casestudy.model.entity.customer.CustomerType;
import com.casestudy.model.entity.dto.annotation.IdCard;
import com.casestudy.model.entity.dto.annotation.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;
    @IdCard
    private String idCard;
    @NotNull
    private Integer gender;
    @Phone
    private String phone;
    @Pattern(regexp = "^(KH-)\\d{4}$",message = "Invalid Customer Id , KH-XXXX")
    private String maKhachHang;
    private String address;
    @Email
    private String email;

    private CustomerType customerType;
}
