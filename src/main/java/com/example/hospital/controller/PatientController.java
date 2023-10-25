package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) String idno,
            @RequestParam(required = false) LocalDate birthday,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer regsitLevelId,
            @RequestParam(required = false) Integer deptId,
            @RequestParam(required = false) Integer doctorId,
            @RequestParam(required = false) Integer active,
            @RequestParam(required = false) LocalDateTime createTime,
            @RequestParam(required = false) Integer book,
            @RequestParam(required = false) LocalDate visittime,
            @RequestParam(required = false) BigDecimal fee,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) String readme,
            @RequestParam(required = false) String present,
            @RequestParam(required = false) String history,
            @RequestParam(required = false) String allergy,
            @RequestParam(required = false) String presentTreat,
            @RequestParam(required = false) String disease,
            @RequestParam(required = false) String suit,
            @RequestParam(required = false) String drug

            ) {
        List<Patient> patients = patientService.findPatients(
                name, gender, idno, birthday, age, address,
                regsitLevelId, deptId, doctorId, active,
                createTime, readme, present, history, allergy, presentTreat,
                disease, suit, drug, status, book, visittime, fee
        );
        return !patients.isEmpty()
                ? ResponseEntity.ok(patients)
                : ResponseEntity.notFound().build();
    }

        @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(patient -> new ResponseEntity<>(patient, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientService.updatePatient(id, patientDetails)
                .map(updatedPatient -> new ResponseEntity<>(updatedPatient, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (patientService.deletePatient(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}