package com.example.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department", schema = "his1222")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Column(name = "dept_description")
    private String deptDescription;
}
