package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.enums.Role;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/create", params = {"login", "password"})
    public ResponseEntity<User> createUser(@RequestParam String login, @RequestParam String password) {
        User user = new User();

        user.setLogin(login);
        user.setPassword(password);
        user.setRole(Role.STANDARD);

        userService.createUser(user);

        return ResponseEntity.ok(user);
    }
}
