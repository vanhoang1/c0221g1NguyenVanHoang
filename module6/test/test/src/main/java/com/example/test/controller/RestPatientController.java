package com.example.test.controller;

import com.example.test.model.entity.dto.PatientDto;
import com.example.test.model.entity.patient.Patient;
import com.example.test.model.service.patient.IPatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/patients")
public class RestPatientController {
    private final IPatientService patientService;

    @Autowired
    public RestPatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patients = patientService.findAllNormal();
        if (patients.isEmpty()) {
            return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Patient> create(@Valid @RequestBody PatientDto patientDto) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto, patient);
        this.patientService.save(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Patient>> getPatients(@PathVariable Long id ){
        Optional<Patient> patient = patientService.findById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Patient> update(@Valid @RequestBody PatientDto patientDto,@PathVariable Long id) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto, patient);
        patient.setId(id);
        this.patientService.save(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
