package com.libertymutual.claimsmanagement.service;

import com.libertymutual.claimsmanagement.entities.PropertyInsurance;
import java.util.List;

public interface PropertyInsuranceService {
    PropertyInsurance createOrUpdatePropertyInsurance(PropertyInsurance insurance);
    PropertyInsurance getPropertyInsuranceById(String id);
    List<PropertyInsurance> getPropertyInsurancesBySurname(String surname);
    List<PropertyInsurance> getAllPropertyInsurances();
    void updatePropertyInsuranceStatus(String id, String newStatus);
    List<PropertyInsurance> findUnassessedClaims();
    void updateClaimOutcome(String id, String outcome);
    void updatePayoutAmount(String id, double amount);
    void deletePropertyInsurance(String id);
    // Additional methods as needed...
}
