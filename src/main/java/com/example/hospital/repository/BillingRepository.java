package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import com.example.hospital.model.billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface BillingRepository extends JpaRepository<billing, Long> {

        List<billing> findByPatientId(Patient patientId);

        List<billing> findByDescription(String description);

        List<billing> findByAmount(String amount);

        List<billing> findByBillDate(LocalDateTime billDate);

        List<billing> findByBillId(Long billId);

}
