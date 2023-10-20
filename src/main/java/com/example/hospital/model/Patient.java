package com.example.hospital.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int gender;

    private String idno;

    private LocalDate birthday;

    private int age;

    private String address;

    @Column(name = "regsit_level_id")
    private int regsitLevelId;

    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "doctor_id")
    private int doctorId;

    private int book;

    private LocalDate visittime;

    private BigDecimal fee;

    private String readme;

    private String present;

    @Column(name = "present_treat")
    private String presentTreat;

    private String history;

    private String allergy;

    private String disease;

    private String suit;

    private String drug;

    private int status;

    private int active = 1;

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createTime;

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Prescription> prescriptions = new ArrayList<>();

    @ManyToMany(mappedBy = "nurses")
    private List<Patient> patients = new ArrayList<>();
}
