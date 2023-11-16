package com.libertymutual.claimsmanagement.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@DynamoDbBean
@DynamoDBTable(tableName = "MotorInsurance")
public class MotorInsurance extends GeneralInsurance {

    private String vehicleMake;
    private String vehicleModel;
    private int yearOfManufacture;

    public MotorInsurance() {
        // Default constructor needed by DynamoDB
    }

    // All-args constructor for convenience


    public MotorInsurance(String id, String policyNumber, String customerName, LocalDate claimStartDate, String estimatedAmount, String claimReason, String incidentDescription, String claimStatus, String claimOutcome, BigDecimal payoutAmount, List<String> taskList, List<String> noteList, LocalDate incidentDate, String additionalDetails, String vehicleMake, String vehicleModel, int yearOfManufacture) {
        super(id, policyNumber, customerName, claimStartDate, estimatedAmount, claimReason, incidentDescription, claimStatus, claimOutcome, payoutAmount, taskList, noteList, incidentDate, additionalDetails);
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.yearOfManufacture = yearOfManufacture;
    }

    @DynamoDBAttribute
    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @DynamoDBAttribute
    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @DynamoDBAttribute
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

}
