package com.libertymutual.claimsmanagement.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@DynamoDbBean
public class PropertyInsurance extends GeneralInsurance {

    private String propertyAddress;
    private String claimOutcome;
    private BigDecimal payoutAmount;
    private String claimStatus;
    public PropertyInsurance() {
        // Default constructor needed by DynamoDB
    }

    // All-args constructor for convenience


    public PropertyInsurance(String propertyAddress, String claimOutcome, BigDecimal payoutAmount, String claimStatus) {
        this.propertyAddress = propertyAddress;
        this.claimOutcome = claimOutcome;
        this.payoutAmount = payoutAmount;
        this.claimStatus = claimStatus;
    }

    public PropertyInsurance(String id, String policyNumber, String customerName, LocalDate claimStartDate, String estimatedAmount, String claimReason, String incidentDescription, String claimStatus, String claimOutcome, BigDecimal payoutAmount, List<String> taskList, List<String> noteList, LocalDate incidentDate, String additionalDetails, String propertyAddress, String claimOutcome1, BigDecimal payoutAmount1, String claimStatus1) {
        super(id, policyNumber, customerName, claimStartDate, estimatedAmount, claimReason, incidentDescription, claimStatus, claimOutcome, payoutAmount, taskList, noteList, incidentDate, additionalDetails);
        this.propertyAddress = propertyAddress;
        this.claimOutcome = claimOutcome1;
        this.payoutAmount = payoutAmount1;
        this.claimStatus = claimStatus1;
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

    public BigDecimal getPayoutAmount() {
        return payoutAmount;
    }

    public void setPayoutAmount(BigDecimal payoutAmount) {
        this.payoutAmount = payoutAmount;
    }
}
