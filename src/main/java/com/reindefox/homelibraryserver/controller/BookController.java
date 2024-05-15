package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.domain.dto.BookCreateRequest;
import com.reindefox.homelibraryserver.domain.dto.FavoriteRequest;
import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.BookService;
import com.reindefox.homelibraryserver.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

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

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> getById(@RequestBody @Valid BookCreateRequest request) {
        // TODO

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/user_all")
    private ResponseEntity<Collection<Book>> getAllByUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Collection<Book> books = user.getBooks();

        if (books != null) {
            return ResponseEntity.ok().body(
                    books
            );
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reading_add/{id}")
    private ResponseEntity<Collection<Book>> addToReading(Authentication authentication,
                                                          @RequestBody @Valid FavoriteRequest request) {
        User user = (User) authentication.getPrincipal();

        Book book = bookService.getById(request.getBookId());
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // TODO

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
