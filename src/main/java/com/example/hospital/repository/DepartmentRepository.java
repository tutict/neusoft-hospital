package com.example.hospital.repository;

import com.example.hospital.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByDeptName(String deptName);

    List<Department> findByDeptDescription(String deptDescription);

    List<Department> findByDeptId(Long deptId);



}
