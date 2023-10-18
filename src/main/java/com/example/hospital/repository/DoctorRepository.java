package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface  DoctorRepository extends JpaRepository<Doctor, Long>{
    List<Doctor> findByName(String name);
    List<Doctor> findByPassword(String password);
    List<Doctor> findByRealname(String realname);
    List<Doctor> findByTelephone(String telephone);
    List<Doctor> findByDeptId(Long deptId);
    List<Doctor> findByUserType(Long userType);
    List<Doctor> findByActive(int active);
    List<Doctor> findByCreateTime(LocalDateTime createTime);
    List<Doctor> findByLastLogin(LocalDateTime lastLogin);
}
