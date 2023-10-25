package com.example.hospital.repository;

import com.example.hospital.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  NurseRepository extends JpaRepository<Nurse, Long>, JpaSpecificationExecutor<Nurse> {

}