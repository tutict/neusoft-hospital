package com.example.hospital.service;


import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.criteria.Predicate;

@Service
public class DoctorService {
    private static DoctorRepository doctorRepository = null;

    public DoctorService(DoctorRepository doctorRepository) {
        DoctorService.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
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

            if (name != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }
            if (password != null) {
                predicates.add(criteriaBuilder.equal(root.get("password"), password));
            }
            if (realname != null) {
                predicates.add(criteriaBuilder.equal(root.get("realname"), realname));
            }
            if (telephone != null) {
                predicates.add(criteriaBuilder.equal(root.get("telephone"), telephone));
            }
            if (deptId != null) {
                predicates.add(criteriaBuilder.equal(root.get("deptId"), deptId));
            }
            if (userType != null) {
                predicates.add(criteriaBuilder.equal(root.get("userType"), userType));
            }
            if (active != null) {
                predicates.add(criteriaBuilder.equal(root.get("active"), active));
            }
            if (createTime != null) {
                predicates.add(criteriaBuilder.equal(root.get("createTime"), createTime));
            }
            if (lastLogin != null) {
                predicates.add(criteriaBuilder.equal(root.get("lastLogin"), lastLogin));
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}