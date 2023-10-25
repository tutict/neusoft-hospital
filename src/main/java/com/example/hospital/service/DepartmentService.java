package com.example.hospital.service;

import com.example.hospital.model.Department;
import com.example.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService( DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(Long name) {
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
        return departmentRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, deptId, value -> criteriaBuilder.equal(root.get("deptId"), value));
            addIfNotNull(predicates, deptName, value -> criteriaBuilder.equal(root.get("deptName"), value));
            addIfNotNull(predicates, deptDescription, value -> criteriaBuilder.equal(root.get("deptDescription"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, jakarta.persistence.criteria.Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }

}
