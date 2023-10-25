package com.example.hospital.repository;

import com.example.hospital.model.patientNurses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  patientNursesRepository extends JpaRepository<patientNurses, Long>, JpaSpecificationExecutor<patientNurses> {

}