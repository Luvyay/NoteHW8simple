package ru.gb.homework_simple.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Класс заметки:
 * Через lombok генерируется конструктор, геттеры и сеттеры, toString и equalsAndHashCode
 * Поля:
 * - id (автоинкрементное)
 * - title (не может быть пустым) заголовок заметки
 * - context (не может быть пустым) содержимое заметки
 * - dateTime (автоматически устанавливается при создании заметки) дата создания заметки
 */
@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String context;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
