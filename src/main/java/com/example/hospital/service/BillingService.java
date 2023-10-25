package com.example.hospital.service;

import com.example.hospital.model.Patient;
import com.example.hospital.model.billing;
import com.example.hospital.repository.BillingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;


    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public List<billing> getAllbillings() {
        return billingRepository.findAll();
    }

    public List<billing> getbillingByBillId(Long billId) {
        return billingRepository.findByBillId(billId);
    }

    public List<billing> getbillingByPatientId(Patient patientId) {
        return billingRepository.findByPatientId(patientId);
    }

    public List<billing> getbillingByDescription(String description) {
        return billingRepository.findByDescription(description);
    }

    public List<billing> getbillingByAmount(String amount) {
        return billingRepository.findByAmount(amount);
    }

    public List<billing> getbillingByBillDate(LocalDateTime billDate) {
        return billingRepository.findByBillDate(billDate);
    }

    public billing getbillingById(Long billId) {
        return billingRepository.findById(billId).orElse(null);
    }

    public billing savebilling(billing billing) {
        return billingRepository.save(billing);
    }

    public boolean deletebilling(Long billId) {
        billingRepository.deleteById(billId);
        return false;
    }

    public billing updateBilling(Long billId, billing billing) {
        Optional<billing> optionalBilling = billingRepository.findById(billId);
        if(optionalBilling.isEmpty()) {
            throw new EntityNotFoundException("Billing with id " + billId + " not found");
        }
        billing.setBillId(billId);
        return billingRepository.save(billing);
    }

    public billing updateBilling(billing billing) {
        return null;
    }
}
