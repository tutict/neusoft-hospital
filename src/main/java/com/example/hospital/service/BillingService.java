package com.example.hospital.service;

import com.example.hospital.model.billing;
import com.example.hospital.repository.BillingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class BillingService {

    private final BillingRepository billingRepository;


    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public List<billing> getAllbillings() {
        return billingRepository.findAll();
    }

    public billing savebilling(billing billing) {
        return billingRepository.save(billing);
    }

    public boolean deletebilling(Long billId) {
        billingRepository.deleteById(billId);
        return false;
    }

    public billing updateBilling(billing billing) {
        Optional<billing> optionalBilling = billingRepository.findById(billId);
        if(optionalBilling.isEmpty()) {
            throw new EntityNotFoundException("Billing with id " + billId + " not found");
        }
        billing.setBillId(billId);
        return billingRepository.save(billing);
    }

    public List<billing> findBilling(
            Long billId,
            Long patientId,
            Long itemId,
            LocalDateTime billDate,
            Double price,
            Integer quantity,
            Double amount
    ){
        return billingRepository.findAll((root, query, criteriaBuilder) -> {
            List<jakarta.persistence.criteria.Predicate> predicates = new java.util.ArrayList<>();

            addIfNotNull(predicates, billId, value -> criteriaBuilder.equal(root.get("billId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, itemId, value -> criteriaBuilder.equal(root.get("itemId"), value));
            addIfNotNull(predicates, billDate, value -> criteriaBuilder.equal(root.get("billDate"), value));
            addIfNotNull(predicates, price, value -> criteriaBuilder.equal(root.get("price"), value));
            addIfNotNull(predicates, quantity, value -> criteriaBuilder.equal(root.get("quantity"), value));
            addIfNotNull(predicates, amount, value -> criteriaBuilder.equal(root.get("amount"), value));

            return criteriaBuilder.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }

}
