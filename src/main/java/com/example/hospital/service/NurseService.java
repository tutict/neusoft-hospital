package com.example.hospital.service;

import com.example.hospital.model.Nurse;
import com.example.hospital.repository.NurseRepository;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class NurseService {

    private final NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public boolean deleteNurse(Long nurseId) {
        if (nurseRepository.existsById(nurseId)) {
            nurseRepository.deleteById(nurseId);
            return true;
        }
        return false;
    }

    public Nurse updateNurse(Long nurseId, Nurse nurse) {
        Optional<Nurse> optionalNurse = nurseRepository.findById(nurseId);
        if(optionalNurse.isPresent()) {
            nurse.setNurseId(nurseId);
            nurseRepository.save(nurse);
        }
        return nurse;
    }

    public List<Nurse> findNurse(
            Long nurseId,
            String nurseName,
            String telephone,
            Long deptId,
            Integer active,
            LocalDateTime createTime
    ){
        return nurseRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, nurseId, value -> criteriaBuilder.equal(root.get("nurseId"), value));
            addIfNotNull(predicates, nurseName, value -> criteriaBuilder.equal(root.get("nurseName"), value));
            addIfNotNull(predicates, telephone, value -> criteriaBuilder.equal(root.get("telephone"), value));
            addIfNotNull(predicates, deptId, value -> criteriaBuilder.equal(root.get("deptId"), value));
            addIfNotNull(predicates, active, value -> criteriaBuilder.equal(root.get("active"), value));
            addIfNotNull(predicates, createTime, value -> criteriaBuilder.equal(root.get("createTime"), value));


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
