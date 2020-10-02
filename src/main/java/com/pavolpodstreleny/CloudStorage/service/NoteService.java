package com.pavolpodstreleny.CloudStorage.service;

import com.pavolpodstreleny.CloudStorage.entity.Note;
import com.pavolpodstreleny.CloudStorage.entity.NoteForm;
import com.pavolpodstreleny.CloudStorage.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteMapper noteMapper;

    public NoteService(final NoteMapper noteMapper) {this.noteMapper = noteMapper;}

    public List<Note> provideNotes(int userId) {
        return noteMapper.getNotes(userId);
    }

    public Note provideNote(int userId, int noteId) {
        return noteMapper.getNote(userId, noteId);
    }

    public int removeNote(int noteId) {
        return noteMapper.delete(noteId);
    }

    public int updateNote(NoteForm noteForm) {
        final Note note = new Note(noteForm.getId(), noteForm.getTitle(), noteForm.getDescription(),
                noteForm.getUserId());
        return noteMapper.update(note);
    }

    public int createNote(NoteForm noteForm) {
        final Note note = new Note(noteForm.getTitle(), noteForm.getDescription(), noteForm.getUserId());
        return noteMapper.insert(note);
    }

}
