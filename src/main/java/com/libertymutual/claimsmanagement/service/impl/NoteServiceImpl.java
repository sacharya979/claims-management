package com.libertymutual.claimsmanagement.service.impl;

import com.libertymutual.claimsmanagement.entities.Note;
import com.libertymutual.claimsmanagement.repository.NoteRepository;
import com.libertymutual.claimsmanagement.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(String id) {
        return noteRepository.findById(id);
    }

    @Override
    public List<Note> getNotesByClaimId(String claimId) {
        return noteRepository.findByClaimId(claimId);
    }

    @Override
    public void deleteNote(String id) {
        noteRepository.deleteById(id);
    }

    // Additional methods as needed...
}
