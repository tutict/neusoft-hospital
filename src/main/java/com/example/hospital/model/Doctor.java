package com.example.hospital.model;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@Entity
@Table(name="user")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "realname", nullable = false)
    private String realname;
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "dept_id", nullable = false)
    private Long deptId;
    @Column(name = "user_type", nullable = false)
    private Long userType;
    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;
    @Column(name = "active", nullable = false, columnDefinition = "int default 1 comment '1:active, 0:inactive'")
    private int active = 1;
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createTime;

    public Doctor() {
    }
}