package com.example.hospital.service;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Optional<Doctor> updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setRealname(String.valueOf(doctorDetails.getClass()));
            // ... set other properties from doctorDetails to doctor
            return doctorRepository.save(doctor);
        });
    }
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findDoctors(String name, String password, String realname, String telephone, Long deptId, Long userType, Integer active, LocalDateTime createTime, LocalDateTime lastLogin) {
        return doctorRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, name, value -> criteriaBuilder.equal(root.get("name"), value));
            addIfNotNull(predicates, password, value -> criteriaBuilder.equal(root.get("password"), value));
            addIfNotNull(predicates, realname, value -> criteriaBuilder.equal(root.get("realname"), value));
            addIfNotNull(predicates, telephone, value -> criteriaBuilder.equal(root.get("telephone"), value));
            addIfNotNull(predicates, deptId, value -> criteriaBuilder.equal(root.get("deptId"), value));
            addIfNotNull(predicates, userType, value -> criteriaBuilder.equal(root.get("userType"), value));
            addIfNotNull(predicates, active, value -> criteriaBuilder.equal(root.get("active"), value));
            addIfNotNull(predicates, createTime, value -> criteriaBuilder.equal(root.get("createTime"), value));
            addIfNotNull(predicates, lastLogin, value -> criteriaBuilder.equal(root.get("lastLogin"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
