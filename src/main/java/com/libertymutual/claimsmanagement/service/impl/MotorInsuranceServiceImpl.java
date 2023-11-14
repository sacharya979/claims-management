package com.libertymutual.claimsmanagement.service.impl;

import com.libertymutual.claimsmanagement.entities.MotorInsurance;
import com.libertymutual.claimsmanagement.repository.MotorInsuranceRepository;
import com.libertymutual.claimsmanagement.service.MotorInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MotorInsuranceServiceImpl implements MotorInsuranceService {

    private final MotorInsuranceRepository motorInsuranceRepository;

    @Autowired
    public MotorInsuranceServiceImpl(MotorInsuranceRepository motorInsuranceRepository) {
        this.motorInsuranceRepository = motorInsuranceRepository;
    }

    @Override
    public MotorInsurance createOrUpdateMotorInsurance(MotorInsurance insurance) {
        return motorInsuranceRepository.save(insurance);
    }

    @Override
    public MotorInsurance getMotorInsuranceById(String id) {
        return motorInsuranceRepository.findById(id);
    }

    @Override
    public List<MotorInsurance> getMotorInsurancesBySurname(String surname) {
        return motorInsuranceRepository.findByCustomerSurname(surname);
    }

    @Override
    public List<MotorInsurance> getAllMotorInsurances() {
        return motorInsuranceRepository.findAll();
    }

    @Override
    public void updateMotorInsuranceStatus(String id, String newStatus) {
        MotorInsurance insurance = getMotorInsuranceById(id);
        if (insurance != null) {
            insurance.setClaimStatus(newStatus);
            motorInsuranceRepository.save(insurance);
        }
    }

    @Override
    public List<MotorInsurance> findUnassessedMotorClaims() {
        // Implementation for retrieving unassessed motor claims
        return motorInsuranceRepository.findAllUnassessedClaims();
    }

    @Override
    public void updateMotorClaimOutcome(String id, String outcome) {
        MotorInsurance insurance = getMotorInsuranceById(id);
        if (insurance != null) {
            insurance.setClaimOutcome(outcome);
            motorInsuranceRepository.save(insurance);
        }
    }

    @Override
    public void updateMotorPayoutAmount(String id, BigDecimal amount) {
        MotorInsurance insurance = getMotorInsuranceById(id);
        if (insurance != null) {
            insurance.setPayoutAmount(amount);
            motorInsuranceRepository.save(insurance);
        }
    }

    @Override
    public void deleteMotorInsurance(String id) {
        motorInsuranceRepository.deleteById(id);
    }

    // Additional methods as needed...
}
