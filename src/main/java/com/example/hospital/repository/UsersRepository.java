package com.example.hospital.repository;

import com.example.hospital.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  UsersRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

}