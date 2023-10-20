package com.example.hospital.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String name;

    private String password;

    private String realname;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Long deptId;

    @Column(name = "user_type", nullable = false)
    private Long userType;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

    private int active = 1;

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createTime;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prescription> prescriptions = new ArrayList<>();
}