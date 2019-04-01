package main.domain;

import main.data.NoteContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class NoteRepository implements INoteRepository {

    @Autowired
    private NoteContext _noteContext;

    public NoteRepository(NoteContext noteContext){
        _noteContext = noteContext;
    }

    public List<Note> GetList() {
        return _noteContext.GetNoteList();
    }

    public List<Note> GetList(String keyword) {
        if (keyword == null){
            return _noteContext.GetNoteList();
        } else {
            return _noteContext.GetNoteList(keyword.toLowerCase());
        }
    }

    public Note GetNoteById(int id){
        return _noteContext.GetNoteById(id);
    }

    public Note AddNote(Note note){
        return _noteContext.AddNote(note);
    }

    public Note RemoveNote(int id) {
        return _noteContext.RemoveNote(id);
    }

    public Note UpdateNote(Note note) {
        return _noteContext.UpdateNote(note);
    }

    public void ResetNotes() {
        _noteContext.ResetNotes();
    }

}
