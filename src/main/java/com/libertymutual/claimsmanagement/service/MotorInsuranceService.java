package com.libertymutual.claimsmanagement.service;

import com.libertymutual.claimsmanagement.entities.MotorInsurance;

import java.math.BigDecimal;
import java.util.List;

public interface MotorInsuranceService {
    MotorInsurance createOrUpdateMotorInsurance(MotorInsurance insurance);
    MotorInsurance getMotorInsuranceById(String id);
    List<MotorInsurance> getMotorInsurancesBySurname(String surname);
    List<MotorInsurance> getAllMotorInsurances();
    void updateMotorInsuranceStatus(String id, String newStatus);
    List<MotorInsurance> findUnassessedMotorClaims();
    void updateMotorClaimOutcome(String id, String outcome);
    void updateMotorPayoutAmount(String id, BigDecimal amount);
    void deleteMotorInsurance(String id);
    // Additional methods as needed...
}
