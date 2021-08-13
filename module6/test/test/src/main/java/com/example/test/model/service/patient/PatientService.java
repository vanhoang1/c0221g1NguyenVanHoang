package com.example.test.model.service.patient;

import com.example.test.model.entity.patient.Patient;
import com.example.test.model.repository.patient.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientService implements IPatientService{

    private final IPatientRepository patientRepository;
    @Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Page<Patient> findAll(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findAllNormal() {
        return patientRepository.findAll();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void remove(Long id) {
        patientRepository.deleteById(id);
    }
}
