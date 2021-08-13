package com.example.test.model.entity.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String medicalRecordId;
    String patientCode;
    String patientName;
    LocalDate hospitalizedDate;
    LocalDate hospitalDischargeDate;
    String reason;
    String treatments;
    String doctor;
}
