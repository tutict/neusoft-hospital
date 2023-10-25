package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

}