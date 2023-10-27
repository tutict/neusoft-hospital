package com.example.hospital.model;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "nurses", schema = "his1222")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nurse_id")
    private Long nurseId;

    @Column(name = "nurse_name")
    private String nurseName;

    @Pattern(regexp = "^[0-9]{10,15}$")
    private String telephone;

    @Column(name = "dept_id")
    private Long deptId;

    private Integer active;

    @Column(name = "create_time", updatable = false, insertable = false)
    private LocalDateTime createTime;

    @ManyToMany(mappedBy = "nurses", fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();

}
