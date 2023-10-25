package com.example.hospital.service;

import com.example.hospital.model.Registration;
import com.example.hospital.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import jakarta.persistence.criteria.Predicate;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public boolean deleteRegistration(Long regId) {
        if (registrationRepository.existsById(regId)) {
            registrationRepository.deleteById(regId);
            return true;
        }
        return false;
    }

    public Registration updateRegistration(Long regId, Registration registration) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(regId);
        if(optionalRegistration.isPresent()) {
            registration.setRegId(regId);
            registrationRepository.save(registration);
        }
        return registration;
    }

    public List<Registration> findRegistration(
            Long regId,
            Long patientId,
            Long deptId,
            LocalDateTime regDate,
            Integer regLevel,
            Integer settle,
            LocalDateTime settleDate,
            Double fee,
            Integer regStatus
    ){
        return registrationRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, regId, value -> criteriaBuilder.equal(root.get("regId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, deptId, value -> criteriaBuilder.equal(root.get("deptId"), value));
            addIfNotNull(predicates, regDate, value -> criteriaBuilder.equal(root.get("regDate"), value));
            addIfNotNull(predicates, regLevel, value -> criteriaBuilder.equal(root.get("regLevel"), value));
            addIfNotNull(predicates, settle, value -> criteriaBuilder.equal(root.get("settle"), value));
            addIfNotNull(predicates, settleDate, value -> criteriaBuilder.equal(root.get("settleDate"), value));
            addIfNotNull(predicates, fee, value -> criteriaBuilder.equal(root.get("fee"), value));
            addIfNotNull(predicates, regStatus, value -> criteriaBuilder.equal(root.get("regStatus"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, jakarta.persistence.criteria.Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
