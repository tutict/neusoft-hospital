package com.example.hospital.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "billing", schema = "his1222")
@Data
public class billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @ManyToOne
    @Column(name = "patient_id", nullable = false)
    private Patient patientId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private String amount;

    @Column(name = "bill_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime billDate;

}