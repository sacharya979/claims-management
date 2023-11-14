package com.libertymutual.claimsmanagement.service.impl;

import com.libertymutual.claimsmanagement.entities.PropertyInsurance;
import com.libertymutual.claimsmanagement.repository.PropertyInsuranceRepository;
import com.libertymutual.claimsmanagement.service.PropertyInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyInsuranceServiceImpl implements PropertyInsuranceService {

    private final PropertyInsuranceRepository propertyInsuranceRepository;

    @Autowired
    public PropertyInsuranceServiceImpl(PropertyInsuranceRepository propertyInsuranceRepository) {
        this.propertyInsuranceRepository = propertyInsuranceRepository;
    }

    @Override
    public PropertyInsurance createOrUpdatePropertyInsurance(PropertyInsurance insurance) {
        return propertyInsuranceRepository.save(insurance);
    }

    @Override
    public PropertyInsurance getPropertyInsuranceById(String id) {
        return propertyInsuranceRepository.findById(id);
    }

    @Override
    public List<PropertyInsurance> getPropertyInsurancesBySurname(String surname) {
        return propertyInsuranceRepository.findByCustomerSurname(surname);
    }

    @Override
    public List<PropertyInsurance> getAllPropertyInsurances() {
        return propertyInsuranceRepository.findAll();
    }

    @Override
    public void updatePropertyInsuranceStatus(String id, String newStatus) {
        PropertyInsurance insurance = getPropertyInsuranceById(id);
        if (insurance != null) {
            insurance.setClaimStatus(newStatus);
            propertyInsuranceRepository.save(insurance);
        }
    }

    @Override
    public List<PropertyInsurance> findUnassessedClaims() {
        // Implementation for retrieving unassessed claims
        return propertyInsuranceRepository.findAllUnassessedClaims();
    }

    @Override
    public void updateClaimOutcome(String id, String outcome) {
        PropertyInsurance insurance = getPropertyInsuranceById(id);
        if (insurance != null) {
            insurance.setClaimOutcome(outcome);
            propertyInsuranceRepository.save(insurance);
        }
    }

    @Override
    public void updatePayoutAmount(String id, double amount) {
        PropertyInsurance insurance = getPropertyInsuranceById(id);
        if (insurance != null) {
            insurance.setPayoutAmount(amount);
            propertyInsuranceRepository.save(insurance);
        }
    }


    @Override
    public void deletePropertyInsurance(String id) {
        propertyInsuranceRepository.deleteById(id);
    }

    // Additional methods as needed...
}
