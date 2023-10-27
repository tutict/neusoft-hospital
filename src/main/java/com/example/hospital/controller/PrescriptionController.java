package com.example.hospital.controller;

import com.example.hospital.model.Prescription;
import com.example.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @PostMapping
    public Prescription savePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(prescription);
    }

    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<?> deletePrescription(@PathVariable Long prescriptionId) {
        if (prescriptionService.deletePrescription(prescriptionId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long prescriptionId, @RequestBody Prescription prescription) {
        Prescription updatedPrescription = prescriptionService.updatePrescription(prescriptionId, prescription);
        if(updatedPrescription.getPrescriptionId() != null) {
            return ResponseEntity.ok(updatedPrescription);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public List<Prescription> findPrescription(
            @RequestParam(required = false) Long prescriptionId,
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) LocalDate dateIssued,
            @RequestParam(required = false) BigDecimal totalCost,
            @RequestParam(required = false) LocalDateTime createTime
    ) {
        return prescriptionService.findPrescription(prescriptionId, patientId, doctorId, dateIssued, totalCost, createTime);
    }
}
