package com.reindefox.homelibraryserver.service;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book getById(int id) {
        return bookRepository.getReferenceById(id);
    }

    public Collection<Book> getAll() {
        return bookRepository.findAll();
    }
}
