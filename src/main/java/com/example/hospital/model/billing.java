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

    private String description;

    private String amount;

    @Column(name = "bill_date", nullable = false)
    private LocalDateTime billDate;

}