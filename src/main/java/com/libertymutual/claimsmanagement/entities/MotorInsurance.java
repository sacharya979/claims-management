package com.libertymutual.claimsmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "motor_insurance_claims")
public class MotorInsurance extends GeneralInsurance {

    /**
     * Make of the vehicle involved in the claim.
     */
    @Column(name = "vehicle_make", nullable = false)
    private String vehicleMake;

    /**
     * Model of the vehicle involved in the claim.
     */
    @Column(name = "vehicle_model", nullable = false)
    private String vehicleModel;

    /**
     * Year of manufacture of the vehicle involved in the claim.
     */
    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    // Getters and setters
}
