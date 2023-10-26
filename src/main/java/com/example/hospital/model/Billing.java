package com.example.hospital.model;

import com.example.hospital.model.Patient;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "billing", schema = "his1222")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "billing_ibfk_1"))
    private Patient patient;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "bill_date")
    private LocalDate billDate;
}