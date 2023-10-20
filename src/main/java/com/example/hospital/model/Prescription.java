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
    @Column(name = "prescription_id")
    private Long prescriptionId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JoinColumn(name = "doctor_id")
    private Prescription prescription;

    @Column(name = "date_issued")
    private LocalDate dateIssued;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrescriptionDetail> prescriptionDetails = new ArrayList<>();

}
