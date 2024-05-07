package com.reindefox.homelibraryserver.service.impl;

import com.reindefox.homelibraryserver.repository.UserRepository;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
