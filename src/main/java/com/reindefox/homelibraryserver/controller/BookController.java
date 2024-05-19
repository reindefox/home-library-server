package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.domain.dto.BookDeleteRequest;
import com.reindefox.homelibraryserver.domain.dto.FavoriteRequest;
import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.repository.UserRepository;
import com.reindefox.homelibraryserver.service.BookService;
import com.reindefox.homelibraryserver.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    /**
     * Получение списка всех книг
     * @return список книг
     */
    @RequestMapping("/all")
    public ResponseEntity<Collection<Book>> getAll() {
        return ResponseEntity.ok().body(bookService.getAll());
    }

    /**
     * Получение книги по ID
     * @param id идентификатор книги
     * @return
     */
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
    public ResponseEntity<Integer> create(@RequestBody @Valid Book request) {
        Book newBook = new Book();

        newBook.setTitle(request.getTitle());
        newBook.setAuthor(request.getAuthor());
        newBook.setDescription(request.getDescription());
        newBook.setImageUrl(request.getImageUrl());
        newBook.setContent(request.getContent());

        Book createdBook = bookService.getBookRepository().save(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook.getId());
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody @Valid Book request) {
        bookService.getBookRepository().findById(request.getId()).ifPresent(book -> {
            book.setTitle(request.getTitle());
            book.setAuthor(request.getAuthor());
            book.setDescription(request.getDescription());
            book.setImageUrl(request.getImageUrl());
            book.setContent(request.getContent());

            bookService.getBookRepository().save(book);
        });

        return ResponseEntity.ok().body(request.getId());
    }

    @PostMapping("/delete")
    public ResponseEntity<Integer> delete(@RequestBody @Valid BookDeleteRequest request) {
        bookService.getBookRepository().deleteById(request.getId());

        return ResponseEntity.ok().body(request.getId());
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

    @RequestMapping("/user_has/{id}")
    private ResponseEntity<HttpStatus> checkUserReading(Authentication authentication, @PathVariable @Valid Integer id) {
        User user = (User) authentication.getPrincipal();

        int bookId = bookService.getById(id).getId();

        if (user.getBooks().stream().anyMatch(b -> b.getId() == bookId))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/get_content/{id}")
    private ResponseEntity<String> getBookContent(@PathVariable @Valid Integer id) {
        Book book = bookService.getById(id);

        if (book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok().body(book.getContent());
    }

    @PostMapping("/update_reading")
    private ResponseEntity<HttpStatus> updateReadingState(Authentication authentication,
                                                          @RequestBody @Valid FavoriteRequest request) {
        User principal = (User) authentication.getPrincipal();
        User user = userService.getById(principal.getId());

        Book book = bookService.getById(request.getBookId());
        if (book == null)
            return ResponseEntity.notFound().build();

        if (request.isState())
            user.addBook(book);
        else
            user.removeBook(book);

        userService.getUserRepository().save(user);

        return ResponseEntity.ok().build();
    }
}
