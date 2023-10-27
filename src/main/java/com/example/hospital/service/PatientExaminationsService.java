package com.example.hospital.service;

import com.example.hospital.model.PatientExaminations;
import com.example.hospital.repository.PatientExaminationsRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PatientExaminationsService {

    private final PatientExaminationsRepository patientExaminationsRepository;

    public PatientExaminationsService(PatientExaminationsRepository patientExaminationsRepository) {
        this.patientExaminationsRepository = patientExaminationsRepository;
    }

    public List<PatientExaminations> getAllPatientExaminationss() {
        return patientExaminationsRepository.findAll();
    }

    public PatientExaminations savePatientExaminations(PatientExaminations patientExaminations) {
        return patientExaminationsRepository.save(patientExaminations);
    }

    public boolean deletePatientExaminations(Long patientExaminationsId) {
        if (patientExaminationsRepository.existsById(patientExaminationsId)) {
            patientExaminationsRepository.deleteById(patientExaminationsId);
            return true;
        }
        return false;
    }

    public PatientExaminations updatePatientExaminations(Long patientExaminationsId, PatientExaminations patientExaminations) {
        Optional<PatientExaminations> optionalPatientExaminations = patientExaminationsRepository.findById(patientExaminationsId);
        if(optionalPatientExaminations.isPresent()) {
            patientExaminations.setPatientId(patientExaminationsId);
            patientExaminationsRepository.save(patientExaminations);
        }
        return patientExaminations;
    }

    public List<PatientExaminations> findPatientExaminations(
            Long examId,
            Long patientId,
            Long itemId,
            LocalDateTime examDate,
            Integer result
    ){
        return patientExaminationsRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, examId, value -> criteriaBuilder.equal(root.get("patientExaminationsId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, itemId, value -> criteriaBuilder.equal(root.get("examinationId"), value));
            addIfNotNull(predicates, examDate, value -> criteriaBuilder.equal(root.get("patientExaminationsDate"), value));
            addIfNotNull(predicates, result, value -> criteriaBuilder.equal(root.get("patientExaminationsStatus"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }

}
