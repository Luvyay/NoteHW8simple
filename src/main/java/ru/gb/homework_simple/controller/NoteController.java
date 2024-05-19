package ru.gb.homework_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework_simple.model.Note;
import ru.gb.homework_simple.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNote() {
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }

    @GetMapping("note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(name = "id") Long id) {
        Note note;

        try {
            note = noteService.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        note.setDateTime(LocalDateTime.now());

        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    @DeleteMapping("note/{id}")
    public ResponseEntity<Note> deleteNoteById(@PathVariable(name = "id") Long id) {
        noteService.deleteNoteById(id);

        return ResponseEntity.ok().build();
    }
}
