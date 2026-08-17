package org.example.postgresqljava21.controller;


import lombok.AllArgsConstructor;
import org.example.postgresqljava21.entity.Book;
import org.example.postgresqljava21.entity.BookMetadata;
import org.example.postgresqljava21.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author WWMP -  8/17/2026
 */

@Controller
@RequestMapping("/ui/books")
@AllArgsConstructor
public class BookViewController {

    private final BookRepository repository;


    // READ ALL
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "book/booklist";
    }

    // CREATE FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Book book = new Book();
        book.setMetadata(new BookMetadata()); // Prevent NullPointerException in form binding
        model.addAttribute("book", book);
        return "book/bookmanage";
    }

    // SAVE / UPDATE
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        repository.save(book);
        return "redirect:/ui/books";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Book book = repository.findById(Long.valueOf(id)).orElseThrow();
        if (book.getMetadata() == null) {
            book.setMetadata(new BookMetadata());
        }
        model.addAttribute("book", book);
        return "book/bookmanage";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        repository.deleteById(Long.valueOf(id));
        return "redirect:/ui/books";
    }
}
