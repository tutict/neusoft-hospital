package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prescriptions")
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDate dateIssued;

    private BigDecimal totalCost;

    @CreationTimestamp
    private LocalDateTime createTime;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrescriptionDetail> prescriptionDetails = new ArrayList<>();

}
