package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.MotorInsurance;
import java.util.List;

public interface MotorInsuranceRepository {
    // Create or update a motor insurance claim
    MotorInsurance save(MotorInsurance insurance);

    // Retrieve a motor insurance claim by its ID
    MotorInsurance findById(String id);

    // Find motor insurance claims by the customer's surname
    List<MotorInsurance> findByCustomerSurname(String surname);

    // Find all claims that are new and have not yet been assessed
    List<MotorInsurance> findAllUnassessedClaims();

    // Find all claims
    List<MotorInsurance> findAll();

    // Find claims based on their status
    List<MotorInsurance> findByStatus(String status);

    // Update the status of a claim
    void updateClaimStatus(String id, String status);

    // Record the outcome of a claim (for Use Case 3)
    void recordClaimOutcome(String id, String outcome);

    // Record the amount paid out for a claim (for Use Case 3)
    void recordPayoutAmount(String id, double amount);

    // Optional: Delete a motor insurance claim by its ID
    void deleteById(String id);

    // Additional methods as needed...
}
