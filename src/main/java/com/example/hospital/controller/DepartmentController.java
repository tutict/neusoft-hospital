package com.example.hospital.controller;

import com.example.hospital.model.Department;
import com.example.hospital.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Create a new Department
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(createdDepartment);
    }

    // Get all Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Get Department by Id
    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long deptId) {
        Department department = departmentService.getDepartmentById(deptId);
        if(department != null) {
            return ResponseEntity.ok(department);
        }
        return ResponseEntity.notFound().build();
    }

    // Update Department
    @PutMapping("/{deptId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long deptId, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(deptId, department);
        if(updatedDepartment != null) {
            return ResponseEntity.ok(updatedDepartment);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Department
    @DeleteMapping("/{deptId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long deptId) {
        if(departmentService.deleteDepartment(deptId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{deptName}")
    public ResponseEntity<List<Department>> getDepartmentByName(@PathVariable String deptName) {
        List<Department> departments = departmentService.getDepartmentByName(deptName);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{description}")
    public ResponseEntity<List<Department>> getDepartmentByDescription(@PathVariable String description) {
        List<Department> departments = departmentService.getDepartmentByDescription(description);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<List<Department>> getDepartmentByDeptId(@PathVariable Long deptId) {
        List<Department> departments = departmentService.getDepartmentByDeptId(deptId);
        return ResponseEntity.ok(departments);
    }
}

