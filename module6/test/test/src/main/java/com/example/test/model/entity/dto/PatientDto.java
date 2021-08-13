package com.example.test.model.entity.dto;

import com.example.test.model.entity.dto.validate.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidDate
public class PatientDto {
    Long id;
    @NotBlank
    String medicalRecordId;
    @NotBlank
    String patientCode;
    @NotBlank
    String patientName;
    LocalDate hospitalizedDate;
    LocalDate hospitalDischargeDate;
    @NotBlank
    String reason;
    @NotBlank
    String treatments;
    @NotBlank
    String doctor;
}
