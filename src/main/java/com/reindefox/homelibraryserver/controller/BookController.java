package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    public ResponseEntity<Collection<Book>> getAll() {
        return ResponseEntity.ok().body(bookService.getAll());
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<Book> getById(@PathVariable @Valid Integer id) {
        Book book = bookService.getById(id);

        if (book != null) {
            return ResponseEntity.ok().body(
                    book
            );
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
