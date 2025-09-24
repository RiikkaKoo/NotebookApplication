package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notebook {
    private ObservableList<Note> notes;

    public Notebook() {
        this.notes = FXCollections.observableArrayList();
    }

    public void saveNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }

    public ObservableList<Note> getNotes() {
        return this.notes;
    }
}
