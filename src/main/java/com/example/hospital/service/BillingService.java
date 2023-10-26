package com.example.hospital.service;

import com.example.hospital.model.Billing;
import com.example.hospital.repository.BillingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public List<Billing> getAllbillings() {
        return billingRepository.findAll();
    }

    public Billing savebilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public void deleteBilling(Long billId) {
        billingRepository.deleteById(billId);
    }


    public Billing updateBilling(Billing billing, Long billId) {
        Optional<Billing> optionalBilling = billingRepository.findById(billId);
        if(optionalBilling.isEmpty()) {
            throw new EntityNotFoundException("Billing with id " + billId + " not found");
        }
        billing.setBillId(billId);
        return billingRepository.save(billing);
    }

    public List<Billing> findBilling(
            Long billId,
            Long patientId,
            String description,
            LocalDate billDate,
            BigDecimal amount
    ){
        return billingRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, billId, value -> criteriaBuilder.equal(root.get("billId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, billDate, value -> criteriaBuilder.equal(root.get("billDate"), value));
            addIfNotNull(predicates, amount, value -> criteriaBuilder.equal(root.get("amount"), value));
            addIfNotNull(predicates, description, value -> criteriaBuilder.equal(root.get("description"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
