package main.data;

import main.domain.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoteContext implements INoteContext {
    private ArrayList<Note> noteList = new ArrayList<>();

    public List<Note> GetNoteList(){
        return noteList;
    }

    public List<Note> GetNoteList(String keyword){

        //filters note by specific id
        List<Note> noteFilteredList = noteList
                .stream()
                .filter(x -> x.getBody()
                        .toLowerCase()
                        .contains(keyword))
                .collect(Collectors.toList());

        return noteFilteredList;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Note not found")
    public Note GetNoteById(int id){

        try{
            //filters note by specific id
            List<Note> filteredNoteList = noteList
                    .stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());

            return filteredNoteList.get(0);
        } catch(IndexOutOfBoundsException iex){
            return null;
        }
        catch (Exception err){
            throw err;
        }
    }



    public Note AddNote (Note note){
        try {
            //if note id is explicit set it
            if (note.getId() > 0){
                noteList.add(note);
                return note;
            }

            //if there are no notes
            if (noteList.size() > 0){
                //get the last id in list to increment for new id
                Note lastNote = noteList.get(noteList.size() -1);
                note.setId(lastNote.getId() + 1);
                noteList.add(note);
                return note;
            }
            //otherwise
            note.setId(1);
            noteList.add(note);
            return note;
        } catch(Exception err){
            throw err;
        }
    }


    public Note UpdateNote (Note note){
        try {
            //loop through each note to find a match and update
            //todo add error handling for not found updated notes
            noteList.forEach(x -> {
                if(x.getId() == note.getId()){
                    x.setBody(note.getBody());
            }
            });
            return note;
        } catch (Exception err){
            throw err;
        }
    }


    public Note RemoveNote (int id){

        try{

            //get note to return
            List<Note> filteredNoteList = noteList
                    .stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());

            //evaluate if note was removed
            boolean isRemoved = noteList.removeIf(x -> x.getId() == id);

            return isRemoved ? filteredNoteList.get(0) : null;
        } catch(IndexOutOfBoundsException iex){
            return null;
        }
        catch (Exception err){
            throw err;
        }

    }

    public void ResetNotes(){
        noteList.clear();
    }

}
