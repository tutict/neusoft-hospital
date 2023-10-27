package com.example.hospital.service;

import com.example.hospital.model.Prescription;
import com.example.hospital.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public boolean deletePrescription(Long prescriptionId) {
        if (prescriptionRepository.existsById(prescriptionId)) {
            prescriptionRepository.deleteById(prescriptionId);
            return true;
        }
        return false;
    }

    public Prescription updatePrescription(Long prescriptionId, Prescription prescription) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(prescriptionId);
        if(optionalPrescription.isPresent()) {
            prescription.setPrescriptionId(prescriptionId);
            prescriptionRepository.save(prescription);
        }
        return prescription;
    }

    public List<Prescription> findPrescription(
            Long prescriptionId,
            Long patientId,
            Long doctorId,
            LocalDate dateIssued,
            BigDecimal totalCost,
            LocalDateTime createTime
    ){
        return prescriptionRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, prescriptionId, value -> criteriaBuilder.equal(root.get("prescriptionId"), value));
            addIfNotNull(predicates, totalCost, value -> criteriaBuilder.equal(root.get("prescriptionStatus"), value));
            addIfNotNull(predicates, dateIssued, value -> criteriaBuilder.equal(root.get("dateIssued"), value));
            addIfNotNull(predicates, createTime, value -> criteriaBuilder.equal(root.get("createTime"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patient").get("patientId"), value));
            addIfNotNull(predicates, doctorId, value -> criteriaBuilder.equal(root.get("doctor").get("userId"), value));


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }


}
