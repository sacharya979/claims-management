package com.libertymutual.claimsmanagement.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@DynamoDbBean
@DynamoDBTable(tableName = "PetInsurance")
public class PetInsurance extends GeneralInsurance {

    private String animalType;
    private String breedOfAnimal;

    public PetInsurance() {
        // Default constructor needed by DynamoDB
    }

    // All-args constructor for convenience

    public PetInsurance(String id, String policyNumber, String customerName, LocalDate claimStartDate, String estimatedAmount, String claimReason, String incidentDescription, String claimStatus, String claimOutcome, BigDecimal payoutAmount, List<String> taskList, List<String> noteList, LocalDate incidentDate, String additionalDetails, String animalType, String breedOfAnimal) {
        super(id, policyNumber, customerName, claimStartDate, estimatedAmount, claimReason, incidentDescription, claimStatus, claimOutcome, payoutAmount, taskList, noteList, incidentDate, additionalDetails);
        this.animalType = animalType;
        this.breedOfAnimal = breedOfAnimal;
    }

    @DynamoDBAttribute
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @DynamoDBAttribute
    public String getBreedOfAnimal() {
        return breedOfAnimal;
    }

    public void setBreedOfAnimal(String breedOfAnimal) {
        this.breedOfAnimal = breedOfAnimal;
    }

}
