package main.controller;

import main.domain.INoteRepository;
import main.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.MULTI_STATUS;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/notes")
public class NoteController {

    @Autowired
    private INoteRepository _noteRepository;


    public NoteController (INoteRepository noteRepository) {
        _noteRepository = noteRepository;
    }

    @GetMapping
    public List<Note> GetNotes(@RequestParam(value = "query", required = false) String query){
        return _noteRepository.GetList(query);
    }

    @GetMapping("/{id}")
    public Note GetNoteById(@PathVariable("id") int id){
        Note response = _noteRepository.GetNoteById(id);

        if (response == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Note not found"
            );
        } else {
           return response;
        }
    }

    @DeleteMapping("/{id}")
    public Note DeleteNote(@PathVariable("id") int id){
        Note response = _noteRepository.RemoveNote(id);

        if (response == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Note not found to be removed"
            );
        } else {
            return response;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note CreateNote(@RequestBody Note note){
        return _noteRepository.AddNote(note);
    }

    @PutMapping
    public Note UpdateNote(@RequestBody Note note){
        return _noteRepository.UpdateNote(note);
    }

    @DeleteMapping("/reset")
    public boolean ResetNotes(){
        _noteRepository.ResetNotes();
        return true;
    }



}
