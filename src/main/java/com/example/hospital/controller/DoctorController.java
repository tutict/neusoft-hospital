package com.example.hospital.controller;

import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String realname,
            @RequestParam(required = false) String telephone,
            @RequestParam(required = false) Long deptId,
            @RequestParam(required = false) Long userType,
            @RequestParam(required = false) Integer active,
            @RequestParam(required = false) LocalDateTime createTime,
            @RequestParam(required = false) LocalDateTime lastLogin) {

        List<Doctor> doctors = doctorService.findDoctors(name, password, realname, telephone, deptId, userType, active, createTime, lastLogin);

        return !doctors.isEmpty()
                ? ResponseEntity.ok(doctors)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
}
