package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable long id) {
        return null;
//        return userRepository.findById(id).toString();
    }
}
