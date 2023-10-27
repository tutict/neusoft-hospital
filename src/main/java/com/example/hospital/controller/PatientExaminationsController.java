package com.example.hospital.controller;

import com.example.hospital.model.PatientExaminations;
import com.example.hospital.service.PatientExaminationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/patient-examinations")
public class PatientExaminationsController {

    private final PatientExaminationsService patientExaminationsService;

    @Autowired
    public PatientExaminationsController(PatientExaminationsService patientExaminationsService) {
        this.patientExaminationsService = patientExaminationsService;
    }

    @GetMapping
    public List<PatientExaminations> getAllPatientExaminations() {
        return patientExaminationsService.getAllPatientExaminationss();
    }

    @PostMapping
    public PatientExaminations savePatientExaminations(@RequestBody PatientExaminations patientExaminations) {
        return patientExaminationsService.savePatientExaminations(patientExaminations);
    }

    @DeleteMapping("/{patientExaminationsId}")
    public ResponseEntity<?> deletePatientExaminations(@PathVariable Long patientExaminationsId) {
        if (patientExaminationsService.deletePatientExaminations(patientExaminationsId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{patientExaminationsId}")
    public ResponseEntity<PatientExaminations> updatePatientExaminations(@PathVariable Long patientExaminationsId, @RequestBody PatientExaminations patientExaminations) {
        PatientExaminations updatedPatientExaminations = patientExaminationsService.updatePatientExaminations(patientExaminationsId, patientExaminations);
        if(updatedPatientExaminations.getPatientId() != null) {
            return ResponseEntity.ok(updatedPatientExaminations);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public List<PatientExaminations> findPatientExaminations(
            @RequestParam(required = false) Long examId,
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) Long itemId,
            @RequestParam(required = false) LocalDateTime examDate,
            @RequestParam(required = false) Integer result
    ) {
        return patientExaminationsService.findPatientExaminations(examId, patientId, itemId, examDate, result);
    }
}
