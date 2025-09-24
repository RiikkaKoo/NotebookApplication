package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Note;
import model.Notebook;


public class NoteController {

    private Notebook notebook = new Notebook();

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveEditsButton;

    @FXML
    private Label error;

    @FXML
    private TextField noteTitle;

    @FXML
    private TextArea noteArea;

    @FXML
    private TextArea noteDisplay;

    @FXML
    private ListView<Note> notes = new ListView<>();

    @FXML
    public void selectNote() {
        Note selected = notes.getSelectionModel().getSelectedItem();
        if (selected != null) {
            noteDisplay.setText(selected.getText());
        } else {
            System.out.println("No notes to select from");
        }
    }

    @FXML
    private void addNote() {
        String title = noteTitle.getText();
        if (title != null && !title.isEmpty()) {
            error.setText("");
            notebook.saveNote(new Note(noteTitle.getText(), noteArea.getText()));
            noteTitle.setText("");
            noteArea.setText("");
            notes.setItems(notebook.getNotes());
        } else {
            error.setText("ADD A TITLE!");
        }
    }

    @FXML
    private void saveEdits() {
        Note selected = notes.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setText(noteDisplay.getText());
        }
        else {
            System.out.println("No note selected.");
        }
    }

    @FXML
    private void deleteNote() {
        Note selected = notes.getSelectionModel().getSelectedItem();
        if (selected != null) {
            notebook.deleteNote(selected);
            noteDisplay.setText("");
        }
        else {
            System.out.println("No note selected.");
        }
    }
}
