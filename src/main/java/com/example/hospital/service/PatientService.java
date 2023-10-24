package com.example.hospital.service;


import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }


    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByName(name);
    }

    public List<Patient> getPatientsByGender(int gender) {
        return patientRepository.findByGender(gender);
    }

    public List<Patient> getPatientsByActiveStatus(int active) {
        return patientRepository.findByActive(active);
    }

    public List<Patient> getPatientsByIdno(String idno) {
        return patientRepository.findByIdno(idno);
    }

    public List<Patient> getPatientsByBirthday(LocalDateTime birthday) {
        return patientRepository.findByBirthday(LocalDate.from(birthday));
    }

    public List<Patient> getPatientsByAge(int age) {
        return patientRepository.findByAge(age);
    }

    public List<Patient> getPatientsByAddress(String address) {
        return patientRepository.findByAddress(address);
    }

    public List<Patient> getPatientsByRegsitLevelId(int regsitLevelId) {
        return patientRepository.findByRegsitLevelId(regsitLevelId);
    }

    public List<Patient> getPatientsByDeptId(int deptId) {
        return patientRepository.findByDeptId(deptId);
    }

    public List<Patient> getPatientsByDoctorId(int doctorId) {
        return patientRepository.findByDoctorId(doctorId);
    }

    public List<Patient> getPatientsByBook(int book) {
        return patientRepository.findByBook(book);
    }

    public List<Patient> getPatientsByVisittime(LocalDateTime visittime) {
        return patientRepository.findByVisittime(LocalDate.from(visittime));
    }

    public List<Patient> getPatientsByFee(int fee) {
        return patientRepository.findByFee(BigDecimal.valueOf(fee));
    }

    public List<Patient> getPatientsByReadme(String readme) {
        return patientRepository.findByReadme(readme);
    }

    public List<Patient> getPatientsByPresent(String present) {
        return patientRepository.findByPresent(present);
    }

    public List<Patient> getPatientsByPresentTreat(String presentTreat) {
        return patientRepository.findByPresentTreat(presentTreat);
    }

    public List<Patient> getPatientsByHistory(String history) {
        return patientRepository.findByHistory(history);
    }

    public List<Patient> getPatientsByAllergy(String allergy) {
        return patientRepository.findByAllergy(allergy);
    }

    public List<Patient> getPatientsByDisease(String disease) {
        return patientRepository.findByDisease(disease);
    }

    public List<Patient> getPatientsBySuit(String suit) {
        return patientRepository.findBySuit(suit);
    }

    public List<Patient> getPatientsByDrug(String drug) {
        return patientRepository.findByDrug(drug);
    }

    public List<Patient> getPatientsByStatus(int status) {
        return patientRepository.findByStatus(status);
    }

    public List<Patient> getPatientsByCreateTime(LocalDateTime createTime) {
        return patientRepository.findByCreateTime(createTime);
    }

}
