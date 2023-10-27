package com.example.hospital.service;

import com.example.hospital.model.Registration;
import com.example.hospital.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            Long doctorId,
            LocalDate registrationDate,
            Registration.RegistrationStatus status
    ){
        return registrationRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, regId, value -> criteriaBuilder.equal(root.get("regId"), value));
            addIfNotNull(predicates, patientId, value -> criteriaBuilder.equal(root.get("patientId"), value));
            addIfNotNull(predicates, deptId, value -> criteriaBuilder.equal(root.get("deptId"), value));
            addIfNotNull(predicates, doctorId, value -> criteriaBuilder.equal(root.get("doctorId"), value));
            addIfNotNull(predicates, registrationDate, value -> criteriaBuilder.equal(root.get("registrationDate"), value));
            addIfNotNull(predicates, status, value -> criteriaBuilder.equal(root.get("status"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, jakarta.persistence.criteria.Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
