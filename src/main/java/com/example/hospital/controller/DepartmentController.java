package com.example.hospital.controller;

import com.example.hospital.model.Department;
import com.example.hospital.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(createdDepartment);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(@RequestParam(required = false) String name,
                                                              @RequestParam(required = false) String description) {
        if (name != null) {
            return ResponseEntity.ok(departmentService.getDepartmentByName(name));
        } else if (description != null) {
            return ResponseEntity.ok(departmentService.getDepartmentByDescription(description));
        }
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long deptId) {
        Optional<Department> departmentOpt = Optional.ofNullable(departmentService.getDepartmentById(deptId));
        return departmentOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long deptId, @RequestBody Department department) {
        Optional<Department> updatedDepartmentOpt = Optional.ofNullable(departmentService.updateDepartment(deptId, department));
        return updatedDepartmentOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long deptId) {
        if (departmentService.deleteDepartment(deptId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
