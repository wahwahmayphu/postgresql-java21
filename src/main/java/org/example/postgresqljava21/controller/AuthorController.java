package org.example.postgresqljava21.controller;


import org.example.postgresqljava21.entity.Author;
import org.example.postgresqljava21.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WWMP -  8/17/2026
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    // CREATE (POST)
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return repository.save(author);
    }

    // READ (GET ALL)
    @GetMapping
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }
}
