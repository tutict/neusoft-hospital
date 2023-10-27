package com.example.hospital.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_nurses")
@Data
public class patientNurses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "nurse_id", nullable = false)
    private Long nursesId;
}
