package com.example.hospital.repository;

import com.example.hospital.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  RegistrationRepository extends JpaRepository<Registration, Long>, JpaSpecificationExecutor<Registration> {

}