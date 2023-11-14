package com.libertymutual.claimsmanagement.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import java.time.LocalDate;

@DynamoDBTable(tableName = "PropertyInsurance")
public class PropertyInsurance extends GeneralInsurance {

    private String propertyAddress;
    private String claimOutcome;
    private double payoutAmount;
    private String claimStatus;
    public PropertyInsurance() {
        // Default constructor needed by DynamoDB
    }

    // All-args constructor for convenience
    public PropertyInsurance(String id, String policyNumber, String customerName, LocalDate claimStartDate, String estimatedAmount, String claimReason, String incidentDescription, LocalDate incidentDate, String additionalDetails, String propertyAddress, String claimOutcome, double payoutAmount, String claimStatus) {
        super(id, policyNumber, customerName, claimStartDate, estimatedAmount, claimReason, incidentDescription, incidentDate, additionalDetails);
        this.propertyAddress = propertyAddress;
        this.claimOutcome = claimOutcome;
        this.payoutAmount = payoutAmount;
        this.claimStatus = claimStatus;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    @DynamoDBAttribute
    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getClaimOutcome() {
        return claimOutcome;
    }

    public void setClaimOutcome(String claimOutcome) {
        this.claimOutcome = claimOutcome;
    }

    public double getPayoutAmount() {
        return payoutAmount;
    }

    public void setPayoutAmount(double payoutAmount) {
        this.payoutAmount = payoutAmount;
    }
}
