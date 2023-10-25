package com.example.hospital.service;


import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import jakarta.persistence.criteria.Predicate;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(patient -> {
            patient.setName(patientDetails.getName());
            // ... set other properties from patientDetails to patient
            return patientRepository.save(patient);
        });
    }

    public boolean deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Patient> findPatients(
            String name,
            Integer gender,
            String idno,
            LocalDate birthday,
            Integer age,
            String address,
            Integer regsitLevelId,
            Integer deptId,
            Integer doctorId,
            Integer book,
            LocalDateTime visittime,
            String fee,
            String readme,
            String present,
            String presentTreat,
            String history,
            String allergy,
            String disease,
            String suit,
            Integer drug,
            Integer status,
            LocalDate active,
            BigDecimal createTime
    ) {
        return patientRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            addIfNotNull(predicates, name, value -> cb.like(root.get("name"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, gender, value -> cb.equal(root.get("gender"), value));
            addIfNotNull(predicates, idno, value -> cb.like(root.get("idno"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, birthday, value -> cb.equal(root.get("birthday"), value));
            addIfNotNull(predicates, age, value -> cb.equal(root.get("age"), value));
            addIfNotNull(predicates, address, value -> cb.like(root.get("address"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, regsitLevelId, value -> cb.equal(root.get("regsitLevelId"), value));
            addIfNotNull(predicates, deptId, value -> cb.equal(root.get("deptId"), value));
            addIfNotNull(predicates, doctorId, value -> cb.equal(root.get("doctorId"), value));
            addIfNotNull(predicates, book, value -> cb.equal(root.get("book"), value));
            addIfNotNull(predicates, visittime, value -> cb.equal(root.get("visittime"), value));
            addIfNotNull(predicates, fee, value -> cb.like(root.get("fee"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, readme, value -> cb.like(root.get("readme"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, present, value -> cb.like(root.get("present"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, presentTreat, value -> cb.like(root.get("presentTreat"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, history, value -> cb.like(root.get("history"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, allergy, value -> cb.like(root.get("allergy"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, disease, value -> cb.like(root.get("disease"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, suit, value -> cb.like(root.get("suit"), "%" + value.trim() + "%"));
            addIfNotNull(predicates, drug, value -> cb.equal(root.get("drug"), value));
            addIfNotNull(predicates, status, value -> cb.equal(root.get("status"), value));
            addIfNotNull(predicates, active, value -> cb.equal(root.get("active"), value));
            addIfNotNull(predicates, createTime, value -> cb.equal(root.get("createTime"), value));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

        private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
            if (value != null) {
                predicates.add(function.apply(value));
            }
        }
}