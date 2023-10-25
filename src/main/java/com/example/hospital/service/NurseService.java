package com.example.hospital.service;

import com.example.hospital.model.Nurse;
import com.example.hospital.repository.NurseRepository;
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
            String nurseAddress,
            String nursePhone,
            String nurseEmail,
            String nursePassword,
            Integer nurseStatus
    ){
        return nurseRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, nurseId, value -> criteriaBuilder.equal(root.get("nurseId"), value));
            addIfNotNull(predicates, nurseName, value -> criteriaBuilder.equal(root.get("nurseName"), value));
            addIfNotNull(predicates, nurseAddress, value -> criteriaBuilder.equal(root.get("nurseAddress"), value));
            addIfNotNull(predicates, nursePhone, value -> criteriaBuilder.equal(root.get("nursePhone"), value));
            addIfNotNull(predicates, nurseEmail, value -> criteriaBuilder.equal(root.get("nurseEmail"), value));
            addIfNotNull(predicates, nursePassword, value -> criteriaBuilder.equal(root.get("nursePassword"), value));
            addIfNotNull(predicates, nurseStatus, value -> criteriaBuilder.equal(root.get("nurseStatus"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
