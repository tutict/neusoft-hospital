package com.example.hospital.repository;

import com.example.hospital.model.PrescriptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  PrescriptionDetailRepository extends JpaRepository<PrescriptionDetail, Long>, JpaSpecificationExecutor<PrescriptionDetail> {
}