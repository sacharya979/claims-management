package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.PetInsurance;
import java.util.List;

public interface PetInsuranceRepository {
    // Create or update a pet insurance claim
    PetInsurance save(PetInsurance insurance);

    // Retrieve a pet insurance claim by its ID
    PetInsurance findById(String id);

    // Find pet insurance claims by the customer's surname
    List<PetInsurance> findByCustomerSurname(String surname);

    // Find all claims that are new and have not yet been assessed
    List<PetInsurance> findAllUnassessedClaims();

    // Find all claims
    List<PetInsurance> findAll();

    // Find claims based on their status
    List<PetInsurance> findByStatus(String status);

    // Update the status of a claim
    void updateClaimStatus(String id, String status);

    // Record the outcome of a claim (for Use Case 3)
    void recordClaimOutcome(String id, String outcome);

    // Record the amount paid out for a claim (for Use Case 3)
    void recordPayoutAmount(String id, double amount);

    // Optional: Delete a pet insurance claim by its ID
    void deleteById(String id);

    // Additional methods as needed...
}
