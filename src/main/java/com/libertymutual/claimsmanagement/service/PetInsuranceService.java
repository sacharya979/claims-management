package com.libertymutual.claimsmanagement.service;

import com.libertymutual.claimsmanagement.entities.PetInsurance;

import java.math.BigDecimal;
import java.util.List;

public interface PetInsuranceService {
    PetInsurance createOrUpdatePetInsurance(PetInsurance insurance);
    PetInsurance getPetInsuranceById(String id);
    List<PetInsurance> getPetInsurancesBySurname(String surname);
    List<PetInsurance> getAllPetInsurances();
    void updatePetInsuranceStatus(String id, String newStatus);
    List<PetInsurance> findUnassessedPetClaims();
    void updatePetClaimOutcome(String id, String outcome);
    void updatePetPayoutAmount(String id, BigDecimal amount);
    void deletePetInsurance(String id);
    // Additional methods as needed...
}
