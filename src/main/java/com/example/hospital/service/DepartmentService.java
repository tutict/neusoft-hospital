package com.example.hospital.service;

import com.example.hospital.model.Department;
import com.example.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService( DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public boolean deleteDepartment(Long deptId) {
        if (departmentRepository.existsById(deptId)) {
            departmentRepository.deleteById(deptId);
            return true;
        }
        return false;
    }

    public Department updateDepartment(Long deptId, Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(deptId);
        if(optionalDepartment.isPresent()) {
            department.setDeptId(deptId);
            departmentRepository.save(department);
        }
        return department;
    }

    public List<Department> findDepartment(

            Long deptId,

            String deptName,

            String deptDescription

    ){

    }


}
