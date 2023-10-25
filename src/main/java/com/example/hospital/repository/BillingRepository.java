package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import com.example.hospital.model.billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;


public interface BillingRepository extends JpaRepository<billing, Long>, JpaSpecificationExecutor<billing> {

}
