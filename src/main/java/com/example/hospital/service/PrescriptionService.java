package com.example.hospital.service;

import com.example.hospital.model.Prescription;
import com.example.hospital.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

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
            Long regId,
            LocalDateTime prescriptionDate,
            Integer prescriptionStatus
    ){
        return prescriptionRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, prescriptionId, value -> criteriaBuilder.equal(root.get("prescriptionId"), value));
            addIfNotNull(predicates, regId, value -> criteriaBuilder.equal(root.get("regId"), value));
            addIfNotNull(predicates, prescriptionDate, value -> criteriaBuilder.equal(root.get("prescriptionDate"), value));
            addIfNotNull(predicates, prescriptionStatus, value -> criteriaBuilder.equal(root.get("prescriptionStatus"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }


}
