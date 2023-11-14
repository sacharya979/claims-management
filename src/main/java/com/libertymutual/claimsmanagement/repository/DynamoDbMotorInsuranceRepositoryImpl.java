package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.MotorInsurance;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DynamoDbMotorInsuranceRepositoryImpl implements MotorInsuranceRepository {

    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<MotorInsurance> motorInsuranceTable;

    public DynamoDbMotorInsuranceRepositoryImpl(DynamoDbEnhancedClient enhancedClient) {
        this.enhancedClient = enhancedClient;
        this.motorInsuranceTable = enhancedClient.table("MotorInsurance", TableSchema.fromBean(MotorInsurance.class));
    }

    @Override
    public MotorInsurance save(MotorInsurance insurance) {
        motorInsuranceTable.putItem(PutItemEnhancedRequest.builder(MotorInsurance.class).item(insurance).build());
        return insurance;
    }

    @Override
    public MotorInsurance findById(String id) {
        return motorInsuranceTable.getItem(GetItemEnhancedRequest.builder()
                .key(Key.builder().partitionValue(id).build())
                .build());
    }

    @Override
    public List<MotorInsurance> findByCustomerSurname(String surname) {
        // Implementation depends on table design, assuming GSI for surname
        return null;
    }

    @Override
    public List<MotorInsurance> findAllUnassessedClaims() {
        // Placeholder for finding all unassessed claims
        return null;
    }

    @Override
    public List<MotorInsurance> findAll() {
        return motorInsuranceTable.scan(ScanEnhancedRequest.builder().build())
                .items()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<MotorInsurance> findByStatus(String status) {
        // Placeholder for finding by status, assuming GSI for status
        return null;
    }

    @Override
    public void updateClaimStatus(String id, String status) {
        // Fetch, update status, and save
    }

    @Override
    public void recordClaimOutcome(String id, String outcome) {
        // Fetch, update outcome, and save
    }

    @Override
    public void recordPayoutAmount(String id, double amount) {
        // Fetch, update payout amount, and save
    }

    @Override
    public void deleteById(String id) {
        motorInsuranceTable.deleteItem(Key.builder().partitionValue(id).build());
    }

    // Additional methods...
}
