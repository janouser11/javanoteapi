package main.domain;

import java.util.ArrayList;
import java.util.List;

public interface INoteRepository {
    List<Note> GetList();
    List<Note> GetList(String keyword);
    Note GetNoteById(int id);
    Note AddNote (Note note);
    Note RemoveNote (int id);
    Note UpdateNote (Note note);
    void ResetNotes();
}
