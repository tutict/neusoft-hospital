package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="nurses")
@Data
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nurseId;

    private String name;
    private String telephone;

    @ManyToMany(mappedBy = "nurses")
    private List<Patient> patients = new ArrayList<>();
}
