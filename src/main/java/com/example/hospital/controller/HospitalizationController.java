package com.example.hospital.controller;

import com.example.hospital.model.Hospitalization;
import com.example.hospital.service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/hospitalizations")
public class HospitalizationController {

    private final HospitalizationService hospitalizationService;

    @Autowired
    public HospitalizationController(HospitalizationService hospitalizationService) {
        this.hospitalizationService = hospitalizationService;
    }

    @GetMapping
    public List<Hospitalization> getAllHospitalizations() {
        return hospitalizationService.getAllHospitalizations();
    }

    @GetMapping("/find")
    public List<Hospitalization> findHospitalizations(
            @RequestParam(required = false) Long hospId,
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) LocalDateTime admissionDate,
            @RequestParam(required = false) LocalDateTime dischargeDate,
            @RequestParam(required = false) String roomNumber,
            @RequestParam(required = false) String bedNumber
    ) {
        return hospitalizationService.findHospitalization(hospId, patientId, admissionDate, dischargeDate, roomNumber, bedNumber);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalization> getHospitalizationById(@PathVariable Long id) {
        Hospitalization hospitalization = hospitalizationService.updateHospitalization(id, null);
        if (hospitalization != null) {
            return ResponseEntity.ok(hospitalization);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Hospitalization saveHospitalization(@RequestBody Hospitalization hospitalization) {
        return hospitalizationService.saveHospitalization(hospitalization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospitalization> updateHospitalization(@PathVariable Long id, @RequestBody Hospitalization hospitalization) {
        Hospitalization updatedHospitalization = hospitalizationService.updateHospitalization(id, hospitalization);
        if (updatedHospitalization != null) {
            return ResponseEntity.ok(updatedHospitalization);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHospitalization(@PathVariable Long id) {
        if (hospitalizationService.deleteHospitalization(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
