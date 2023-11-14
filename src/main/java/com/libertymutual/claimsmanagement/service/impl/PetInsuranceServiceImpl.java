package com.libertymutual.claimsmanagement.service.impl;

import com.libertymutual.claimsmanagement.entities.PetInsurance;
import com.libertymutual.claimsmanagement.repository.PetInsuranceRepository;
import com.libertymutual.claimsmanagement.service.PetInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PetInsuranceServiceImpl implements PetInsuranceService {

    private final PetInsuranceRepository petInsuranceRepository;

    @Autowired
    public PetInsuranceServiceImpl(PetInsuranceRepository petInsuranceRepository) {
        this.petInsuranceRepository = petInsuranceRepository;
    }

    @Override
    public PetInsurance createOrUpdatePetInsurance(PetInsurance insurance) {
        return petInsuranceRepository.save(insurance);
    }

    @Override
    public PetInsurance getPetInsuranceById(String id) {
        return petInsuranceRepository.findById(id);
    }

    @Override
    public List<PetInsurance> getPetInsurancesBySurname(String surname) {
        return petInsuranceRepository.findByCustomerSurname(surname);
    }

    @Override
    public List<PetInsurance> getAllPetInsurances() {
        return petInsuranceRepository.findAll();
    }

    @Override
    public void updatePetInsuranceStatus(String id, String newStatus) {
        PetInsurance insurance = getPetInsuranceById(id);
        if (insurance != null) {
            insurance.setClaimStatus(newStatus);
            petInsuranceRepository.save(insurance);
        }
    }

    @Override
    public List<PetInsurance> findUnassessedPetClaims() {
        // Implementation for retrieving unassessed pet claims
        return petInsuranceRepository.findAllUnassessedClaims();
    }

    @Override
    public void updatePetClaimOutcome(String id, String outcome) {
        PetInsurance insurance = getPetInsuranceById(id);
        if (insurance != null) {
            insurance.setClaimOutcome(outcome);
            petInsuranceRepository.save(insurance);
        }
    }

    @Override
    public void updatePetPayoutAmount(String id, BigDecimal amount) {
        PetInsurance insurance = getPetInsuranceById(id);
        if (insurance != null) {
            insurance.setPayoutAmount(amount);
            petInsuranceRepository.save(insurance);
        }
    }

    @Override
    public void deletePetInsurance(String id) {
        petInsuranceRepository.deleteById(id);
    }

    // Additional methods as needed...
}
