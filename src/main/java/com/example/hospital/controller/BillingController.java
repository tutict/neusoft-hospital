package com.example.hospital.controller;


import com.example.hospital.model.Billing;
import com.example.hospital.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public ResponseEntity<List<Billing>> getAllBilling() {
        return new ResponseEntity<>(billingService.getAllbillings(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Billing> saveBilling(@RequestBody Billing billing) {
        return new ResponseEntity<>(billingService.savebilling(billing), HttpStatus.CREATED);
    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long billId) {
        billingService.deleteBilling(billId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{billId}")
    public ResponseEntity<Billing> updateBilling(@RequestBody Billing billing, @PathVariable Long billId) {
        return new ResponseEntity<>(billingService.updateBilling(billing, billId), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Billing>> findBilling(
            @RequestParam(required = false) Long billId,
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) LocalDate billDate,
            @RequestParam(required = false) BigDecimal amount
    ) {
        return new ResponseEntity<>(billingService.findBilling(billId, patientId, description, billDate, amount), HttpStatus.OK);
    }
}
