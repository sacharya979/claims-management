package com.libertymutual.claimsmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
@Entity
@Table(name = "property_insurance_claims")
public class PropertyInsurance extends GeneralInsurance {

    /**
     * Address of the property affected by the claim.
     */
    @Column(name = "property_address", nullable = false)
    private String propertyAddress;

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }
}
