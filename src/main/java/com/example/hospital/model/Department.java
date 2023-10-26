package com.example.hospital.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "department", schema = "his1222")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_description")
    private String deptDescription;
}