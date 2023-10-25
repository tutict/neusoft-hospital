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

            if (name != null && !name.trim().isEmpty()) {
                predicates.add(cb.like(root.get("name"), "%" + name + "%"));
            }

            if (gender != null) {
                predicates.add(cb.equal(root.get("gender"), gender));
            }

            if (idno != null && !idno.trim().isEmpty()) {
                predicates.add(cb.like(root.get("idno"), "%" + idno + "%"));
            }

            if (birthday != null) {
                predicates.add(cb.equal(root.get("birthday"), birthday));
            }

            // 这里的逻辑是为每个属性添加一个查询谓词，以此类推
            if (age != null) {
                predicates.add(cb.equal(root.get("age"), age));
            }

            if (address != null && !address.trim().isEmpty()) {
                predicates.add(cb.like(root.get("address"), "%" + address + "%"));
            }

            if (regsitLevelId != null) {
                predicates.add(cb.equal(root.get("regsit_level_id"), regsitLevelId));
            }

            if (deptId != null) {
                predicates.add(cb.equal(root.get("dept_id"), deptId));
            }

            if (doctorId != null) {
                predicates.add(cb.equal(root.get("doctor_id"), doctorId));
            }

            if (book != null) {
                predicates.add(cb.equal(root.get("book"), book));
            }

            if (visittime != null) {
                predicates.add(cb.equal(root.get("visittime"), visittime));
            }

            if (fee != null) {
                predicates.add(cb.equal(root.get("fee"), fee));
            }

            if (readme != null && !readme.trim().isEmpty()) {
                predicates.add(cb.like(root.get("readme"), "%" + readme + "%"));
            }

            if (present != null && !present.trim().isEmpty()) {
                predicates.add(cb.like(root.get("present"), "%" + present + "%"));
            }

            if (presentTreat != null && !presentTreat.trim().isEmpty()) {
                predicates.add(cb.like(root.get("present_treat"), "%" + presentTreat + "%"));
            }

            if (history != null && !history.trim().isEmpty()) {
                predicates.add(cb.like(root.get("history"), "%" + history + "%"));
            }

            if (allergy != null && !allergy.trim().isEmpty()) {
                predicates.add(cb.like(root.get("allergy"), "%" + allergy + "%"));
            }

            if (disease != null && !disease.trim().isEmpty()) {
                predicates.add(cb.like(root.get("disease"), "%" + disease + "%"));
            }

            if (suit != null && !suit.trim().isEmpty()) {
                predicates.add(cb.like(root.get("suit"), "%" + suit + "%"));
            }

            if (drug != null) {
                predicates.add(cb.like(root.get("drug"), "%" + drug + "%"));
            }

            if (status != null) {
                predicates.add(cb.equal(root.get("status"), status));
            }

            if (active != null) {
                predicates.add(cb.equal(root.get("active"), active));
            }

            if (createTime != null) {
                predicates.add(cb.equal(root.get("create_time"), createTime));
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }


}