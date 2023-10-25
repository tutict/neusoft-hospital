package com.example.hospital.repository;

import com.example.hospital.model.PatientExaminations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  PatientExaminationsRepository extends JpaRepository<PatientExaminations, Long>, JpaSpecificationExecutor<PatientExaminations> {

}