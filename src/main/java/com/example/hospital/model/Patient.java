package com.example.hospital.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "patient", schema = "his1222")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer gender;

    @Column(name = "idno")
    private String idno;

    private LocalDate birthday;

    private Integer age;

    private String address;

    @Column(name = "regsit_level_id")
    private Integer regsitLevelId;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "doctor_id")
    private Integer doctorId;

    private Integer book;

    @Column(name = "visittime")
    private LocalDate visitTime;

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

    private Integer status;

    private Integer active;

    @Column(name = "create_time", updatable = false, insertable = false)
    private LocalDateTime createTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_nurses",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "nurse_id")
    )
    private Set<Nurse> nurses = new HashSet<>();

}