package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Patient>> getPatientsByName(@PathVariable String name) {
        List<Patient> patients = patientService.getPatientsByName(name);
        return new ResponseEntity<>(patients, HttpStatus.OK);

    }

    @GetMapping("/{gender}")
    public ResponseEntity<List<Patient>> getPatientsByGender(@PathVariable int gender) {
        List<Patient> patients = patientService.getPatientsByGender(gender);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{active}")
    public ResponseEntity<List<Patient>> getPatientsByActiveStatus(@PathVariable int active) {
        List<Patient> patients = patientService.getPatientsByActiveStatus(active);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{idno}")
    public ResponseEntity<List<Patient>> getPatientsByIdno(@PathVariable String idno) {
        List<Patient> patients = patientService.getPatientsByIdno(idno);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{birthday}")
    public ResponseEntity<List<Patient>> getPatientsByBirthday(@PathVariable LocalDateTime birthday) {
        List<Patient> patients = patientService.getPatientsByBirthday(birthday);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{age}")
    public ResponseEntity<List<Patient>> getPatientsByAge(@PathVariable int age) {
        List<Patient> patients = patientService.getPatientsByAge(age);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{address}")
    public ResponseEntity<List<Patient>> getPatientsByAddress(@PathVariable String address) {
        List<Patient> patients = patientService.getPatientsByAddress(address);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{regsitLevelId}")
    public ResponseEntity<List<Patient>> getPatientsByRegsitLevelId(@PathVariable int regsitLevelId) {
        List<Patient> patients = patientService.getPatientsByRegsitLevelId(regsitLevelId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<List<Patient>> getPatientsByDeptId(@PathVariable int deptId) {
        List<Patient> patients = patientService.getPatientsByDeptId(deptId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorId(@PathVariable int doctorId) {
        List<Patient> patients = patientService.getPatientsByDoctorId(doctorId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{book}")
    public ResponseEntity<List<Patient>> getPatientsByBook(@PathVariable int book) {
        List<Patient> patients = patientService.getPatientsByBook(book);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{visittimes}")
    public ResponseEntity<List<Patient>> getPatientsByVisittimes(@PathVariable LocalDateTime visittimes) {
        List<Patient> patients = patientService.getPatientsByVisittime(visittimes);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{fee}")
    public ResponseEntity<List<Patient>> getPatientsByFee(@PathVariable int fee) {
        List<Patient> patients = patientService.getPatientsByFee(fee);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{readme}")
    public ResponseEntity<List<Patient>> getPatientsByReadme(@PathVariable String readme) {
        List<Patient> patients = patientService.getPatientsByReadme(readme);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{present}")
    public ResponseEntity<List<Patient>> getPatientsByPresent(@PathVariable String present) {
        List<Patient> patients = patientService.getPatientsByPresent(present);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{presentTreat}")
    public ResponseEntity<List<Patient>> getPatientsByPresentTreat(@PathVariable String presentTreat) {
        List<Patient> patients = patientService.getPatientsByPresentTreat(presentTreat);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{history}")
    public ResponseEntity<List<Patient>> getPatientsByHistory(@PathVariable String history) {
        List<Patient> patients = patientService.getPatientsByHistory(history);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{allergy}")
    public ResponseEntity<List<Patient>> getPatientsByAllergy(@PathVariable String allergy) {
        List<Patient> patients = patientService.getPatientsByAllergy(allergy);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{disease}")
    public ResponseEntity<List<Patient>> getPatientsByDisease(@PathVariable String disease) {
        List<Patient> patients = patientService.getPatientsByDisease(disease);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{suit}")
    public ResponseEntity<List<Patient>> getPatientsBySuit(@PathVariable String suit) {
        List<Patient> patients = patientService.getPatientsBySuit(suit);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{drug}")
    public ResponseEntity<List<Patient>> getPatientsByDrug(@PathVariable String drug) {
        List<Patient> patients = patientService.getPatientsByDrug(drug);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Patient>> getPatientsByStatus(@PathVariable int status) {
        List<Patient> patients = patientService.getPatientsByStatus(status);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{createTime}")
    public ResponseEntity<List<Patient>> getPatientsByCreateTime(@PathVariable LocalDateTime createTime) {
        List<Patient> patients = patientService.getPatientsByCreateTime(createTime);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }






}