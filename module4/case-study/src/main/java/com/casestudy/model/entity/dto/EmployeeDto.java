package com.casestudy.model.entity.dto;

import com.casestudy.model.entity.account.AppUser;
import com.casestudy.model.entity.dto.annotation.IdCard;
import com.casestudy.model.entity.dto.annotation.Phone;
import com.casestudy.model.entity.employee.Division;
import com.casestudy.model.entity.employee.Education;
import com.casestudy.model.entity.employee.Position;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotNull
    private String name;

    private Position position;

    private Education education;

    private Division division;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;
    @IdCard
    private String idCard;
    @Min(0)
    private Double salary;
    @Phone
    private String phone;

    private String address;
    @Email
    private String email;

    private AppUser appUser;
}
