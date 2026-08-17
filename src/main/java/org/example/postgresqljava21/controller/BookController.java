package org.example.postgresqljava21.controller;


import org.example.postgresqljava21.entity.Book;
import org.example.postgresqljava21.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WWMP -  8/17/2026
 */

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
