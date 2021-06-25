package com.validate_form_reg.model.validate.dto;

import com.validate_form_reg.model.validate.annotation.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;
//    @Pattern()
    @Phone
    private String phoneNumber;
    @Min(18)
    private Integer age;
    @Email
    private String email;
}