package com.example.hospital.repository;

import com.example.hospital.model.examinationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface examinationItemRepository extends JpaRepository<examinationItem, Long>, JpaSpecificationExecutor<examinationItem> {

}