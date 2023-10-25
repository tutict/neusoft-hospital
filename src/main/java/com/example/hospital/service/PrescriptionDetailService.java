package com.example.hospital.service;

import com.example.hospital.model.Prescription;
import com.example.hospital.model.PrescriptionDetail;
import com.example.hospital.repository.PrescriptionDetailRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

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
            Long prescriptionDetailId,
            Long prescriptionId,
            Long itemId,
            Integer quantity,
            Double price,
            Double amount
    ){
        return prescriptionDetailRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, prescriptionDetailId, value -> criteriaBuilder.equal(root.get("prescriptionDetailId"), value));
            addIfNotNull(predicates, prescriptionId, value -> criteriaBuilder.equal(root.get("prescriptionId"), value));
            addIfNotNull(predicates, itemId, value -> criteriaBuilder.equal(root.get("itemId"), value));
            addIfNotNull(predicates, quantity, value -> criteriaBuilder.equal(root.get("quantity"), value));
            addIfNotNull(predicates, price, value -> criteriaBuilder.equal(root.get("price"), value));
            addIfNotNull(predicates, amount, value -> criteriaBuilder.equal(root.get("amount"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }


}
