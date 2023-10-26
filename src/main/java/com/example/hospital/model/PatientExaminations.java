package com.example.hospital.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "patient_examinations", schema = "his1222")
public class PatientExaminations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "result")
    private String result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private examinationItem examinationItems;
}