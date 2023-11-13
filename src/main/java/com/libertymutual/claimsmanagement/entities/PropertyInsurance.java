package com.libertymutual.claimsmanagement.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import java.time.LocalDate;

@DynamoDBTable(tableName = "PropertyInsurance")
public class PropertyInsurance extends GeneralInsurance {

    private String propertyAddress;

    public PropertyInsurance() {
        // Default constructor needed by DynamoDB
    }

    // All-args constructor for convenience
    public PropertyInsurance(String id, String policyNumber, String customerName,
                             LocalDate claimStartDate, String estimatedAmount,
                             String claimReason, String incidentDescription,
                             LocalDate incidentDate, String additionalDetails,
                             String propertyAddress) {
        super(id, policyNumber, customerName, claimStartDate, estimatedAmount,
                claimReason, incidentDescription, incidentDate, additionalDetails);
        this.propertyAddress = propertyAddress;
    }

    @DynamoDBAttribute
    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }
    
}
