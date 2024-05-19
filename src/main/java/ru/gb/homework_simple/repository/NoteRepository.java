package ru.gb.homework_simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.homework_simple.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
