package com.example.hospital.controller;

import com.example.hospital.model.Registration;
import com.example.hospital.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @PostMapping
    public Registration saveRegistration(@RequestBody Registration registration) {
        return registrationService.saveRegistration(registration);
    }

    @DeleteMapping("/{regId}")
    public ResponseEntity<?> deleteRegistration(@PathVariable Long regId) {
        if (registrationService.deleteRegistration(regId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{regId}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Long regId, @RequestBody Registration registration) {
        Registration updatedRegistration = registrationService.updateRegistration(regId, registration);
        if(updatedRegistration.getRegId() != null) {
            return ResponseEntity.ok(updatedRegistration);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public List<Registration> findRegistration(
            @RequestParam(required = false) Long regId,
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) Long deptId,
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) LocalDate registrationDate,
            @RequestParam(required = false) Registration.RegistrationStatus status
    ) {
        return registrationService.findRegistration(regId, patientId, deptId, doctorId, registrationDate, status);
    }
}
