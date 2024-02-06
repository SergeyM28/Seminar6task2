package ru.mikhailov.seminar6task2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private String author;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
