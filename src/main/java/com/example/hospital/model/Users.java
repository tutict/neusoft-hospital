package com.example.hospital.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_type")
    private UserType userType;

    private String email;

    private String phone;

    enum UserType {
        DOCTOR, NURSE, PATIENT;
    }
}