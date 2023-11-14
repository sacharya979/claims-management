package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.Note;

import java.time.LocalDate;
import java.util.List;

public interface NoteRepository {
    // Create a new note or update an existing one
    Note save(Note note);

    // Retrieve a specific note by its ID
    Note findById(String id);

    // Find all notes associated with a specific claim
    List<Note> findByClaimId(String claimId);

    // Retrieve all notes made on a specific date or within a date range
    List<Note> findByDateRange(LocalDate startDate, LocalDate endDate);

    // Retrieve notes based on their content (full-text search, if supported)
    List<Note> findByContent(String searchString);

    // Optional: Delete a note by its ID
    void deleteById(String id);

    // Additional methods as needed for specific use cases...
}
