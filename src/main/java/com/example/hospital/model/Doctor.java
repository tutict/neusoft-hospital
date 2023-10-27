package com.example.hospital.model;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "doctor", schema = "his1222")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String username;

    private String password;

    private String realname;

    @Pattern(regexp = "^[0-9]{10,15}$")
    private String telephone;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "user_type")
    private Long userType;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    private Integer active;

    @Column(name = "create_time", updatable = false, insertable = false)
    private LocalDateTime createTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id", insertable = false, updatable = false)
    private Department department;
}