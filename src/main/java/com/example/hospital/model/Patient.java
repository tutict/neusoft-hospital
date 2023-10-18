package com.example.hospital.model;

import lombok.Data;
import lombok.Getter;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Data
@Entity
@Table(name="usr")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private int gender;

    @Column(name = "idno")
    private String idno;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "regsit_level_id")
    private int regsitLevelId;

    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "book")
    private int book;

    @Column(name = "visittime")
    private LocalDate visittime;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "readme")
    private String readme;

    @Column(name = "present")
    private String present;

    @Column(name = "present_treat")
    private String presentTreat;

    @Column(name = "history")
    private String history;

    @Column(name = "allergy")
    private String allergy;

    @Column(name = "disease")
    private String disease;

    @Column(name = "suit")
    private String suit;

    @Column(name = "drug")
    private String drug;

    @Column(name = "status")
    private int status;

    @Column(name = "active", nullable = false, columnDefinition = "int default 1 comment '1:active, 0:inactive'")
    private int active = 1;

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createTime;

    public Patient(){

    }

}