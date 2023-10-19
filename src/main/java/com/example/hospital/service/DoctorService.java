package com.example.hospital.service;


import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class DoctorService {
    private static DoctorRepository doctorRepository = null;

    public DoctorService(DoctorRepository doctorRepository) {
        DoctorService.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    public List<Doctor> getDoctorByPassword(String password) {
        return doctorRepository.findByPassword(password);
    }

    public List<Doctor> getDoctorByRealname(String realname) {
        return doctorRepository.findByRealname(realname);
    }

    public List<Doctor> getDoctorByTelephone(String telephone) {
        return doctorRepository.findByTelephone(telephone);
    }

    public List<Doctor> getDoctorByDeptId(Long deptId) {
        return doctorRepository.findByDeptId(deptId);
    }

    public List<Doctor> getDoctorByUserType(Long userType) {
        return doctorRepository.findByUserType(userType);
    }

    public List<Doctor> getDoctorByActive(int active) {
        return doctorRepository.findByActive(active);
    }

    public List<Doctor> getDoctorByCreateTime(LocalDateTime createTime) {
        return doctorRepository.findByCreateTime(createTime);
    }

    public List<Doctor> getDoctorByLastLogin(LocalDateTime lastLogin) {
        return doctorRepository.findByLastLogin(lastLogin);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

}