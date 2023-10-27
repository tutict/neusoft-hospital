package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patientOptional = patientService.getPatientById(id);
        return patientOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Optional<Patient> updatedPatient = patientService.updatePatient(id, patientDetails);
        return updatedPatient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        if (patientService.deletePatient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public List<Patient> findPatients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) String idno,
            @RequestParam(required = false) LocalDate birthday,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer regsitLevelId,
            @RequestParam(required = false) Integer deptId,
            @RequestParam(required = false) Integer doctorId,
            @RequestParam(required = false) Integer book,
            @RequestParam(required = false) LocalDateTime visittime,
            @RequestParam(required = false) String fee,
            @RequestParam(required = false) String readme,
            @RequestParam(required = false) String present,
            @RequestParam(required = false) String presentTreat,
            @RequestParam(required = false) String history,
            @RequestParam(required = false) String allergy,
            @RequestParam(required = false) String disease,
            @RequestParam(required = false) String suit,
            @RequestParam(required = false) Integer drug,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) LocalDate active,
            @RequestParam(required = false) BigDecimal createTime
    ) {
        return patientService.findPatients(name, gender, idno, birthday, age, address, regsitLevelId, deptId, doctorId, book, visittime, fee, readme, present, presentTreat, history, allergy, disease, suit, drug, status, active, createTime);
    }
}
