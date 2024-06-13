package com.saad.model;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static List<Note> notes = new ArrayList<>();
    private static int nextId = 1;

    public List<Note> getAllNotes() {
        return notes;
    }

    public void addNote(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }
}
