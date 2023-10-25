package com.example.hospital.service;

import com.example.hospital.model.examinationItem;
import com.example.hospital.repository.examinationItemRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class examinationItemService {
    private final examinationItemRepository ExaminationItemRepository;

    public examinationItemService(examinationItemRepository ExaminationItemRepository){
        this.ExaminationItemRepository = ExaminationItemRepository;
    }

    public Optional<examinationItem> getExaminationItemById(Long id){
        return ExaminationItemRepository.findById(id);
    }

    public void deleteExaminationItemById(Long id){
        ExaminationItemRepository.deleteById(id);
    }

    public Optional<examinationItem> updateExaminationItem(Long id, examinationItem examinationItemDetails){
        return ExaminationItemRepository.findById(id).map(examinationItem -> {
            examinationItem.setItemName(examinationItemDetails.getItemName());
            examinationItem.setCost(examinationItemDetails.getCost());
            return ExaminationItemRepository.save(examinationItem);
        });
    }

    public examinationItem saveExaminationItem(examinationItem examinationItem){
        return ExaminationItemRepository.save(examinationItem);
    }

    public List<examinationItem> findExaminationItem(String itemName, Double cost){
        return ExaminationItemRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, itemName, value -> criteriaBuilder.equal(root.get("itemName"), value));
            addIfNotNull(predicates, cost, value -> criteriaBuilder.equal(root.get("cost"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function){
        if(value != null){
            predicates.add(function.apply(value));
        }
    }

}
