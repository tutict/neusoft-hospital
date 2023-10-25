package com.example.hospital.service;

import com.example.hospital.model.patientNurses;
import com.example.hospital.repository.patientNursesRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class patientNursesService {

    private final patientNursesRepository patientNursesRepository;

    public patientNursesService(patientNursesRepository patientNursesRepository) {
        this.patientNursesRepository = patientNursesRepository;
    }

    public List<patientNurses> getAllpatientNursess() {
        return patientNursesRepository.findAll();
    }

    public patientNurses savepatientNurses(patientNurses patientNurses) {
        return patientNursesRepository.save(patientNurses);
    }

    public boolean deletepatientNurses(Long patientNursesId) {
        if (patientNursesRepository.existsById(patientNursesId)) {
            patientNursesRepository.deleteById(patientNursesId);
            return true;
        }
        return false;
    }

    public patientNurses updatepatientNurses(Long patientNursesId, patientNurses patientNurses) {
        Optional<patientNurses> optionalpatientNurses = patientNursesRepository.findById(patientNursesId);
        if(optionalpatientNurses.isPresent()) {
            patientNurses.setPatientId(patientNursesId);
            patientNursesRepository.save(patientNurses);
        }
        return patientNurses;
    }

    public List<patientNurses> findpatientNurses(
            Long patientNursesId,
            Long patientId,
            Long nurseId,
            LocalDateTime patientNursesDate,
            Integer patientNursesStatus
    ){
        return patientNursesRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, patientNursesId, value -> criteriaBuilder.equal(root.get("patientNursesId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, nurseId, value -> criteriaBuilder.equal(root.get("nurseId"), value));
            addIfNotNull(predicates, patientNursesDate, value -> criteriaBuilder.equal(root.get("patientNursesDate"), value));
            addIfNotNull(predicates, patientNursesStatus, value -> criteriaBuilder.equal(root.get("patientNursesStatus"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }

}
