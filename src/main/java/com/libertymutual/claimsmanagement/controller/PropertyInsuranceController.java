package com.libertymutual.claimsmanagement.controller;

import com.libertymutual.claimsmanagement.entities.PropertyInsurance;
import com.libertymutual.claimsmanagement.service.PropertyInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/property-insurance")
public class PropertyInsuranceController {

    private final PropertyInsuranceService propertyInsuranceService;
    private static final Logger log = LoggerFactory.getLogger(PropertyInsuranceController.class);

    @Autowired
    public PropertyInsuranceController(PropertyInsuranceService propertyInsuranceService) {
        this.propertyInsuranceService = propertyInsuranceService;
    }

    @PostMapping
    public ResponseEntity<PropertyInsurance> createPropertyInsurance(@RequestBody PropertyInsurance insurance) {
        if (insurance.getId() == null || insurance.getId().isEmpty()) {
            insurance.setId(UUID.randomUUID().toString()); // Set a unique ID if not provided
        }
        return ResponseEntity.ok(propertyInsuranceService.createOrUpdatePropertyInsurance(insurance));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PropertyInsurance> getPropertyInsurance(@PathVariable String id) {
        return ResponseEntity.ok(propertyInsuranceService.getPropertyInsuranceById(id));
    }

    @GetMapping
    public ResponseEntity<List<PropertyInsurance>> getAllPropertyInsurances() {
        List<PropertyInsurance> insurances = propertyInsuranceService.getAllPropertyInsurances();
        log.info("Retrieved Property Insurances: {}", insurances);
        return ResponseEntity.ok(insurances);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PropertyInsurance> updatePropertyInsurance(@PathVariable String id, @RequestBody PropertyInsurance insurance) {
        // Assuming the insurance object contains the updated information
        return ResponseEntity.ok(propertyInsuranceService.createOrUpdatePropertyInsurance(insurance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePropertyInsurance(@PathVariable String id) {
        propertyInsuranceService.deletePropertyInsurance(id);
        return ResponseEntity.ok().build();
    }

    // Additional endpoints as needed...
}
