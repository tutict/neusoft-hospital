package com.example.hospital.controller;

import com.example.hospital.model.patientNurses;
import com.example.hospital.service.patientNursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-nurses")
public class PatientNursesController {

    private final patientNursesService patientNursesService;

    @Autowired
    public PatientNursesController(patientNursesService patientNursesService) {
        this.patientNursesService = patientNursesService;
    }

    @GetMapping
    public List<patientNurses> getAllpatientNurses() {
        return patientNursesService.getAllpatientNursess();
    }

    @PostMapping
    public patientNurses savepatientNurses(@RequestBody patientNurses patientNurses) {
        return patientNursesService.savepatientNurses(patientNurses);
    }

    @DeleteMapping("/{patientNursesId}")
    public ResponseEntity<?> deletepatientNurses(@PathVariable Long patientNursesId) {
        if (patientNursesService.deletepatientNurses(patientNursesId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{patientNursesId}")
    public ResponseEntity<patientNurses> updatepatientNurses(@PathVariable Long patientNursesId, @RequestBody patientNurses patientNurses) {
        patientNurses updatedPatientNurses = patientNursesService.updatepatientNurses(patientNursesId, patientNurses);
        if(updatedPatientNurses.getPatientId() != null) {
            return ResponseEntity.ok(updatedPatientNurses);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public List<patientNurses> findpatientNurses(
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) Long nurseId
    ) {
        return patientNursesService.findpatientNurses(patientId, nurseId);
    }
}

