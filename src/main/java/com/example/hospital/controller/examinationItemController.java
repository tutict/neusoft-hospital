package com.example.hospital.controller;

import com.example.hospital.model.examinationItem;
import com.example.hospital.service.examinationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examination-items")
public class examinationItemController {

    private final examinationItemService examinationItemService;

    @Autowired
    public examinationItemController(examinationItemService examinationItemService) {
        this.examinationItemService = examinationItemService;
    }

    @GetMapping
    public List<examinationItem> findExaminationItems(
            @RequestParam(required = false) Long itemId,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) Double cost
    ) {
        return examinationItemService.findExaminationItem(itemId, itemName, cost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<examinationItem> getExaminationItemById(@PathVariable Long id) {
        return examinationItemService.getExaminationItemById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public examinationItem saveExaminationItem(@RequestBody examinationItem examinationItem) {
        return examinationItemService.saveExaminationItem(examinationItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<examinationItem> updateExaminationItem(@PathVariable Long id, @RequestBody examinationItem examinationItemDetails) {
        return examinationItemService.updateExaminationItem(id, examinationItemDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExaminationItemById(@PathVariable Long id) {
        try {
            examinationItemService.deleteExaminationItemById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
