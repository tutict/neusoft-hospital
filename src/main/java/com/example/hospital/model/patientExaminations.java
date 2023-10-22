package com.example.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient_examinations")
@Data
public class patientExaminations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long exam_id;

    @Column(name = "patient_id")
    private Long patientId;


}
