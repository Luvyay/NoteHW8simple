package ru.gb.homework_simple.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework_simple.aspect.TrackUserAction;
import ru.gb.homework_simple.model.Note;
import ru.gb.homework_simple.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    /**
     * Получение всех заметок
     * @return - список заметок
     */
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    /**
     * Получение заметки по id
     * @param id
     * @return - заметка
     */
    @TrackUserAction
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    /**
     * Создание заметки
     * @param note
     * @return - заметка
     */
    @TrackUserAction
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Обновление заметки
     * @param note
     * @return - обновленная заметка
     */
    @TrackUserAction
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Удаление заметки
     * @param id
     */
    @TrackUserAction
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
