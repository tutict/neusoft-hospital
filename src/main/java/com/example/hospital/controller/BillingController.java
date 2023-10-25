package com.example.hospital.controller;

import com.example.hospital.model.billing;
import com.example.hospital.service.BillingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<billing>> getAllbillings() {
        List<billing> billings = billingService.getAllbillings();
        return new ResponseEntity<>(billings, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<billing>> getbillingByBillId(@PathVariable("id") Long id) {
        List<billing> billing = billingService.getbillingByBillId(id);
        return new ResponseEntity<>(billing, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<billing> savebilling(@RequestBody billing billing) {
        billing newBilling = billingService.savebilling(billing);
        return new ResponseEntity<>(newBilling, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<billing> updateBilling(@RequestBody billing billing) {
        billing updateBilling = billingService.updateBilling(billing);
        return new ResponseEntity<>(updateBilling, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletebilling(@PathVariable("id") Long id) {
        billingService.deletebilling(id);
        return new ResponseEntity<>(OK);
    }



}
