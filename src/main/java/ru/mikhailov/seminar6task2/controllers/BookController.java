package ru.mikhailov.seminar6task2.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.seminar6task2.model.Book;
import ru.mikhailov.seminar6task2.model.Reader;
import ru.mikhailov.seminar6task2.repositories.BookRepository;
import ru.mikhailov.seminar6task2.repositories.ReaderRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookRepository.findById(id).orElseThrow(null);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PutMapping("/{id}/reader/{readerId}")
    public Book assignReaderToBook(@PathVariable Long id, @PathVariable Long readerId){
        Book bookToProcess = bookRepository.findById(id).get();
        Reader readerToProcess = readerRepository.findById(readerId).get();

        bookToProcess.setReader(readerToProcess);
        return bookRepository.save(bookToProcess);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookRepository.deleteById(id);
    }
}
