package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="nurses")
@Data
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nurse_id")
    private Long nurseId;

    @Column(name = "nurse_name")
    private String name;

    private String telephone;

    @Column(name = "dept_id")
    private Long deptId;

    private int active = 1;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createTime;


    @ManyToMany(mappedBy = "patients")
    private List<Nurse> nurses = new ArrayList<>();
}
