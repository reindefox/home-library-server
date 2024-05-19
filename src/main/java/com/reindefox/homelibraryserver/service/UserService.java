package com.reindefox.homelibraryserver.service;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public UserDetailsService userDetailsService() {
        return this::findByLogin;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
