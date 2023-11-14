package com.libertymutual.claimsmanagement.controller;

import com.libertymutual.claimsmanagement.entities.PropertyInsurance;
import com.libertymutual.claimsmanagement.service.PropertyInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-insurance")
public class PropertyInsuranceController {

    private final PropertyInsuranceService propertyInsuranceService;

    @Autowired
    public PropertyInsuranceController(PropertyInsuranceService propertyInsuranceService) {
        this.propertyInsuranceService = propertyInsuranceService;
    }

    @PostMapping
    public ResponseEntity<PropertyInsurance> createPropertyInsurance(@RequestBody PropertyInsurance insurance) {
        return ResponseEntity.ok(propertyInsuranceService.createOrUpdatePropertyInsurance(insurance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyInsurance> getPropertyInsurance(@PathVariable String id) {
        return ResponseEntity.ok(propertyInsuranceService.getPropertyInsuranceById(id));
    }

    @GetMapping
    public ResponseEntity<List<PropertyInsurance>> getAllPropertyInsurances() {
        return ResponseEntity.ok(propertyInsuranceService.getAllPropertyInsurances());
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
