package com.reindefox.homelibraryserver.service.impl;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.repository.UserRepository;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addReadingNow(Book book) {

    }

    @Override
    public void deleteReadingNow(int id) {

    }

    @Override
    public void addToRead(Book book) {

    }

    @Override
    public void deleteToRead(int id) {

    }
}
