package ru.mikhailov.seminar6task2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.seminar6task2.model.Reader;
import ru.mikhailov.seminar6task2.repositories.ReaderRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reader")
public class ReaderController {
    private  final ReaderRepository readerRepository;

    @GetMapping
    public List<Reader> getAllReaders(){
        return readerRepository.findAll();
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader){
        return readerRepository.save(reader);
    }

}
