package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.Note;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DynamoDbNoteRepositoryImpl implements NoteRepository {

    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<Note> noteTable;

    public DynamoDbNoteRepositoryImpl(DynamoDbEnhancedClient enhancedClient) {
        this.enhancedClient = enhancedClient;
        this.noteTable = enhancedClient.table("Note", TableSchema.fromBean(Note.class));
    }

    @Override
    public Note save(Note note) {
        noteTable.putItem(PutItemEnhancedRequest.builder(Note.class).item(note).build());
        return note;
    }

    @Override
    public Note findById(String id) {
        return noteTable.getItem(GetItemEnhancedRequest.builder()
                .key(Key.builder().partitionValue(id).build())
                .build());
    }

    @Override
    public List<Note> findByClaimId(String claimId) {
        // Implementation depends on table design, assuming GSI for claimId
        return null;
    }

    @Override
    public List<Note> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public List<Note> findByContent(String searchString) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        noteTable.deleteItem(Key.builder().partitionValue(id).build());
    }

    // Additional methods as needed...
}
