package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public interface PatientRepository extends JpaRepository<Patient, Long>{
    List<Patient> findByName(String name);
    List<Patient> findByGender(int gender);
    List<Patient> findByIdno(String idno);
    List<Patient> findByBirthday(LocalDate birthday);
    List<Patient> findByAge(int age);
    List<Patient> findByAddress(String address);
    List<Patient> findByRegsitLevelId(int regsitLevelId);
    List<Patient> findByDeptId(int deptId);
    List<Patient> findByDoctorId(int doctorId);
    List<Patient> findByBook(int book);
    List<Patient> findByVisittime(LocalDate visittime);
    List<Patient> findByFee(BigDecimal fee);
    List<Patient> findByReadme(String readme);
    List<Patient> findByPresent(String present);
    List<Patient> findByPresentTreat(String presentTreat);
    List<Patient> findByHistory(String history);
    List<Patient> findByAllergy(String allergy);
    List<Patient> findByDisease(String disease);
    List<Patient> findBySuit(String suit);
    List<Patient> findByDrug(String drug);
    List<Patient> findByStatus(int status);
    List<Patient> findByCreateTime(LocalDateTime createTime);
    List<Patient> findByActive(int active);


}