package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Doctor;

import java.util.List;

public interface  DoctorRepository extends JpaRepository {
    List<Doctor> findBySpecialization(String specialization);
}
