package com.example.hospital.service;


import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List getAllDoctors() {
        return doctorRepository.findAll();
    }
    private Doctor getDoctorById(Long id) {
        return (Doctor) doctorRepository.findById(id).orElse(null);
    }
    public Doctor saveDoctor(Doctor doctor) {
        return (Doctor) doctorRepository.save(doctor);
    }
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    public List<Doctor> getDoctorBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

}
