package com.example.hospital.controller;

import com.example.hospital.model.Department;
import com.example.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> findAll(
            @RequestParam(required = false) Long deptId,
            @RequestParam(required = false) String deptName,
            @RequestParam(required = false) String deptDescription
    ) {
        return departmentService.findDepartment(deptId, deptName, deptDescription);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        List<Department> departments = departmentService.findDepartment(id, null, null);
        return departments.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(departments.get(0));
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deleted = departmentService.deleteDepartment(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
