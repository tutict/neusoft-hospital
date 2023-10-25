package com.example.hospital.repository;

import com.example.hospital.model.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  HospitalizationRepository extends JpaRepository<Hospitalization, Long>, JpaSpecificationExecutor<Hospitalization> {

}