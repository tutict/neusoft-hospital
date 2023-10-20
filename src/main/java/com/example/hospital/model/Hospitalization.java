package com.example.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "hospitalization")
@Data
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hosp_id", nullable = false)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "admission_date", nullable = false)
    private LocalDateTime adminssionDate;

    @Column(name = "discharge_date", nullable = false)
    private LocalDateTime dischargeTime;

    @Column(name = "room_number", nullable = false)
    private Long roomNumber;

    @Column(name = "bed_number", nullable = false)
    private Long bedNumber;

}
