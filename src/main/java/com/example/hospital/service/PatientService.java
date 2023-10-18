package com.example.hospital.service;


import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }


    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByName(name);
    }

    public List<Patient> getPatientsByGender(int gender) {
        return patientRepository.findByGender(gender);
    }


    public List<Patient> getPatientsByActiveStatus(int active) {
        return patientRepository.findByActive(active);
    }
}
