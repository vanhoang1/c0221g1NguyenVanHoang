package com.example.test.model.repository.patient;

import com.example.test.model.entity.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long> {
}
