package com.example.hospital.controller;

import com.example.hospital.model.billing;
import com.example.hospital.service.BillingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<billing>> getAllBillings() {
        List<billing> billings = billingService.getAllBillings();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<billing> getBillingById(@PathVariable("id") Long id) {
        billing billing = billingService.getBillingById(id);
        return new ResponseEntity<>(billing, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<billing> addBilling(@RequestBody billing billing) {
        billing newBilling = billingService.addBilling(billing);
        return new ResponseEntity<>(newBilling, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<billing> updateBilling(@RequestBody billing billing) {
        billing updateBilling = billingService.updateBilling(billing);
        return new ResponseEntity<>(updateBilling, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBilling(@PathVariable("id") Long id) {
        billingService.deleteBilling(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
