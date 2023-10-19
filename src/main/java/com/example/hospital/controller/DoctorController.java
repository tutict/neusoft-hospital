package com.example.hospital.controller;
import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        final List<Doctor> doctors= doctorService.getAllDoctors();
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(name="id") Long id){
        final Optional<Doctor> doctor= doctorService.getDoctorById(id);
        return doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor){
        Doctor saveDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(saveDoctor,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable(name="id")Long id){
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Doctor>> getDoctorByName(@PathVariable(name="name") String name){
        final List<Doctor> doctors= doctorService.getDoctorByName(name);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{password}")
    public ResponseEntity<List<Doctor>> getDoctorByPassword(@PathVariable(name="password") String password){
        final List<Doctor> doctors= doctorService.getDoctorByPassword(password);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{realname}")
    public ResponseEntity<List<Doctor>> getDoctorByRealname(@PathVariable(name="realname") String realname){
        final List<Doctor> doctors= doctorService.getDoctorByRealname(realname);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{telephone}")
    public ResponseEntity<List<Doctor>> getDoctorByTelephone(@PathVariable(name="telephone") String telephone){
        final List<Doctor> doctors= doctorService.getDoctorByTelephone(telephone);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{deptId}")
    public ResponseEntity<List<Doctor>> getDoctorByDeptId(@PathVariable(name="deptId") Long deptId){
        final List<Doctor> doctors= doctorService.getDoctorByDeptId(deptId);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{userType}")
    public ResponseEntity<List<Doctor>> getDoctorByUserType(@PathVariable(name="userType") Long userType){
        final List<Doctor> doctors= doctorService.getDoctorByUserType(userType);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{active}")
    public ResponseEntity<List<Doctor>> getDoctorByActive(@PathVariable(name="active") int active){
        final List<Doctor> doctors= doctorService.getDoctorByActive(active);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{createTime}")
    public ResponseEntity<List<Doctor>> getDoctorByCreateTime(@PathVariable(name="createTime") LocalDateTime createTime){
        final List<Doctor> doctors= doctorService.getDoctorByCreateTime(createTime);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{lastLogin}")
    public ResponseEntity<List<Doctor>> getDoctorByLastLogin(@PathVariable(name="lastLogin") LocalDateTime lastLogin){
        final List<Doctor> doctors= doctorService.getDoctorByLastLogin(lastLogin);
        return !doctors.isEmpty()
                ? new ResponseEntity<>(doctors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
