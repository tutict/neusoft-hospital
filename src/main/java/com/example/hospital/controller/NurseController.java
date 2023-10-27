package com.example.hospital.controller;

import com.example.hospital.model.Nurse;
import com.example.hospital.service.NurseService;
import jakarta.validation.Valid;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    private final NurseService nurseService;

    @Autowired
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @GetMapping("/find")
    public List<Nurse> findNurses(
            @RequestParam(required = false) Long nurseId,
            @RequestParam(required = false) String nurseName,
            @RequestParam(required = false) String telephone,
            @RequestParam(required = false) Long deptId,
            @RequestParam(required = false) Integer active,
            @RequestParam(required = false) LocalDateTime createTime
    ) {
        return nurseService.findNurse(nurseId, nurseName, telephone, deptId, active, createTime);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
        Nurse nurse = nurseService.updateNurse(id, null);
        if (nurse != null) {
            return ResponseEntity.ok(nurse);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Nurse saveNurse(@Valid @RequestBody Nurse nurse) {
        return nurseService.saveNurse(nurse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @Valid @RequestBody Nurse nurse) {
        Nurse updatedNurse = nurseService.updateNurse(id, nurse);
        if (updatedNurse != null) {
            return ResponseEntity.ok(updatedNurse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNurse(@PathVariable Long id) {
        if (nurseService.deleteNurse(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
