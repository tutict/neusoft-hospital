package com.example.hospital.controller;

import com.example.hospital.model.Prescription;
import com.example.hospital.model.PrescriptionDetail;
import com.example.hospital.service.PrescriptionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/prescription-details")
public class PrescriptionDetailController {

    private final PrescriptionDetailService prescriptionDetailService;

    @Autowired
    public PrescriptionDetailController(PrescriptionDetailService prescriptionDetailService) {
        this.prescriptionDetailService = prescriptionDetailService;
    }

    @GetMapping
    public List<PrescriptionDetail> getAllPrescriptionDetails() {
        return prescriptionDetailService.getAllPrescriptionDetails();
    }

    @PostMapping
    public PrescriptionDetail savePrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail) {
        return prescriptionDetailService.savePrescriptionDetail(prescriptionDetail);
    }

    @DeleteMapping("/{prescriptionDetailId}")
    public ResponseEntity<?> deletePrescriptionDetail(@PathVariable Long prescriptionDetailId) {
        if (prescriptionDetailService.deletePrescriptionDetail(prescriptionDetailId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{prescriptionDetailId}")
    public ResponseEntity<PrescriptionDetail> updatePrescriptionDetail(@PathVariable Prescription prescriptionDetailId, @RequestBody PrescriptionDetail prescriptionDetail) {
        PrescriptionDetail updatedPrescriptionDetail = prescriptionDetailService.updatePrescriptionDetail(prescriptionDetailId, prescriptionDetail);
        if(updatedPrescriptionDetail.getPrescription() != null) {
            return ResponseEntity.ok(updatedPrescriptionDetail);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public List<PrescriptionDetail> findPrescriptionDetail(
            @RequestParam(required = false) Long detailId,
            @RequestParam(required = false) Long prescriptionId,
            @RequestParam(required = false) String medicationName,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) BigDecimal unitPrice,
            @RequestParam(required = false) BigDecimal totalPrice,
            @RequestParam(required = false) String dosageInstructions
    ) {
        return prescriptionDetailService.findPrescriptionDetail(detailId, prescriptionId, medicationName, quantity, unitPrice, totalPrice, dosageInstructions);
    }
}
