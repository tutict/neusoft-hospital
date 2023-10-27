package com.example.hospital.service;

import com.example.hospital.model.Hospitalization;
import com.example.hospital.repository.HospitalizationRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class HospitalizationService {

    private final HospitalizationRepository hospitalizationRepository;

    public HospitalizationService(HospitalizationRepository hospitalizationRepository) {
        this.hospitalizationRepository = hospitalizationRepository;
    }

    public List<Hospitalization> getAllHospitalizations() {
        return hospitalizationRepository.findAll();
    }

    public Hospitalization saveHospitalization(Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

    public boolean deleteHospitalization(Long hospitalizationId) {
        if (hospitalizationRepository.existsById(hospitalizationId)) {
            hospitalizationRepository.deleteById(hospitalizationId);
            return true;
        }
        return false;
    }

    public Hospitalization updateHospitalization(Long hospitalizationId, Hospitalization hospitalization) {
        Optional<Hospitalization> optionalHospitalization = hospitalizationRepository.findById(hospitalizationId);
        if(optionalHospitalization.isPresent()) {
            hospitalization.setHospId(hospitalizationId);
            hospitalizationRepository.save(hospitalization);
        }
        return hospitalization;
    }

    public List<Hospitalization> findHospitalization(
            Long hospId,
            Long patientId,
            LocalDateTime admissionDate,
            LocalDateTime dischargeDate,
            String roomNumber,
            String bedNumber
    ){
        return hospitalizationRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, hospId, value -> criteriaBuilder.equal(root.get("hospitalizationId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, admissionDate, value -> criteriaBuilder.equal(root.get("hospitalizationDate"), value));
            addIfNotNull(predicates, dischargeDate, value -> criteriaBuilder.equal(root.get("hospitalizationDischargeDate"), value));
            addIfNotNull(predicates, roomNumber, value -> criteriaBuilder.equal(root.get("hospitalizationRoomNumber"), value));
            addIfNotNull(predicates, bedNumber, value -> criteriaBuilder.equal(root.get("hospitalizationBedNumber"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }

}
