package com.example.hospital.service;

import com.example.hospital.model.Prescription;
import com.example.hospital.model.PrescriptionDetail;
import com.example.hospital.repository.PrescriptionDetailRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PrescriptionDetailService {

    private final PrescriptionDetailRepository prescriptionDetailRepository;

    public PrescriptionDetailService(PrescriptionDetailRepository prescriptionDetailRepository) {
        this.prescriptionDetailRepository = prescriptionDetailRepository;
    }

    public List<PrescriptionDetail> getAllPrescriptionDetails() {
        return prescriptionDetailRepository.findAll();
    }

    public PrescriptionDetail savePrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        return prescriptionDetailRepository.save(prescriptionDetail);
    }

    public boolean deletePrescriptionDetail(Long prescriptionDetailId) {
        if (prescriptionDetailRepository.existsById(prescriptionDetailId)) {
            prescriptionDetailRepository.deleteById(prescriptionDetailId);
            return true;
        }
        return false;
    }

    public PrescriptionDetail updatePrescriptionDetail(Prescription prescriptionDetailId, PrescriptionDetail prescriptionDetail) {
        Optional<PrescriptionDetail> optionalPrescriptionDetail = prescriptionDetailRepository.findById(prescriptionDetailId.getPrescriptionId());
        if(optionalPrescriptionDetail.isPresent()) {
            prescriptionDetail.setPrescription(prescriptionDetailId);
            prescriptionDetailRepository.save(prescriptionDetail);
        }
        return prescriptionDetail;
    }

    public List<PrescriptionDetail> findPrescriptionDetail(
            Long detailId,
            Long prescriptionId,
            String medicationName,
            Integer quantity,
            BigDecimal unitPrice,
            BigDecimal totalPrice,
            String dosageInstructions
    ){
        return prescriptionDetailRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, quantity, value -> criteriaBuilder.equal(root.get("quantity"), value));
            addIfNotNull(predicates, unitPrice, value -> criteriaBuilder.equal(root.get("unitPrice"), value));
            addIfNotNull(predicates, totalPrice, value -> criteriaBuilder.equal(root.get("totalPrice"), value));
            addIfNotNull(predicates, dosageInstructions, value -> criteriaBuilder.equal(root.get("dosageInstructions"), value));
            addIfNotNull(predicates, detailId, value -> criteriaBuilder.equal(root.get("detailId"), value));
            addIfNotNull(predicates, medicationName, value -> criteriaBuilder.equal(root.get("medicationName"), value));
            addIfNotNull(predicates, prescriptionId, value -> criteriaBuilder.equal(root.get("prescription").get("prescriptionId"), value));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }


}
