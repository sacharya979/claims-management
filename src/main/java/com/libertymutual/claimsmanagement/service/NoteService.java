package com.libertymutual.claimsmanagement.service;

import com.libertymutual.claimsmanagement.entities.Note;
import java.util.List;

public interface NoteService {
    Note createOrUpdateNote(Note note);
    Note getNoteById(String id);
    List<Note> getNotesByClaimId(String claimId);
    void deleteNote(String id);
    // Additional methods as needed...
}
