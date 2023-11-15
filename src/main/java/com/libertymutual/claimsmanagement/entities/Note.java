package com.libertymutual.claimsmanagement.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.time.LocalDateTime;
@DynamoDbBean
@DynamoDBTable(tableName = "Note")
public class Note {

    private String id;
    private String claimId; // Associates the note with a specific insurance claim
    private String content;
    private LocalDateTime timestamp;

    public Note() {
        // Default constructor for DynamoDB
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    @DynamoDBAttribute
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @DynamoDBAttribute
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
