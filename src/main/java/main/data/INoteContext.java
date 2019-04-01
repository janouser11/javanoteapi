package main.data;

import main.domain.Note;

import java.util.List;
import java.util.stream.Stream;

public interface INoteContext {
    List<Note> GetNoteList();
    List<Note> GetNoteList(String keyword);
    Note GetNoteById(int id);
    Note AddNote (Note note);
    Note RemoveNote (int id);
    Note UpdateNote (Note note);
    void ResetNotes();
}
