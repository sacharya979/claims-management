package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.PropertyInsurance;
import java.util.List;

public interface PropertyInsuranceRepository {
    // Create or update a property insurance claim
    PropertyInsurance save(PropertyInsurance insurance);

    // Retrieve a property insurance claim by its ID
    PropertyInsurance findById(String id);

    // Find property insurance claims by the customer's surname
    List<PropertyInsurance> findByCustomerSurname(String surname);

    // Find all claims that are new and have not yet been assessed
    List<PropertyInsurance> findAllUnassessedClaims();

    // Find all claims
    List<PropertyInsurance> findAll();

    // Find claims based on their status
    List<PropertyInsurance> findByStatus(String status);

    // Update the status of a claim
    void updateClaimStatus(String id, String status);

    // Record the outcome of a claim (for Use Case 3)
    void recordClaimOutcome(String id, String outcome);

    // Record the amount paid out for a claim (for Use Case 3)
    void recordPayoutAmount(String id, double amount);

    // Optional: Delete a property insurance claim by its ID
    void deleteById(String id);
}
