package com.reindefox.homelibraryserver.service;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.repository.UserRepository;
import com.reindefox.homelibraryserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(int id) {
        return userRepository.getReferenceById(id);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void addReadingNow(Book book) {

    }

    public void deleteReadingNow(int id) {

    }

    public void addToRead(Book book) {

    }

    public void deleteToRead(int id) {

    }

    public UserDetailsService userDetailsService() {
        return this::findByLogin;
    }
}
