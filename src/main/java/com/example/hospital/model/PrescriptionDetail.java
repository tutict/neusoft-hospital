package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="prescription_details")
@Data
public class PrescriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    private String medicationName;

    private int quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private String dosageInstructions;
}

