package com.example.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "examination_items")
@Data
public class examinationItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    private Long cost;
}
