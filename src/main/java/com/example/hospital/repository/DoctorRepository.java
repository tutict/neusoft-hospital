package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface  DoctorRepository extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {

}
