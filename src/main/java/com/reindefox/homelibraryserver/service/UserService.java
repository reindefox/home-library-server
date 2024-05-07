package com.reindefox.homelibraryserver.service;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.model.User;

public interface UserService {
    User getById(int id);
    User findByLogin(String login);
    void createUser(User user);
    void addReadingNow(Book book);
    void deleteReadingNow(int id);
    void addToRead(Book book);
    void deleteToRead(int id);
}
