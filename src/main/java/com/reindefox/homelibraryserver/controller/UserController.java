package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @RequestMapping("/get/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        User user = userService.getById(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/find/{login}")
    public ResponseEntity<User> findByLogin(@PathVariable String login) {
        User user = userService.findByLogin(login);

        if (user != null) {
            return ResponseEntity.ok(user);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/create", params = {"login", "password"})
    public ResponseEntity<User> createUser(@RequestParam String login, @RequestParam String password) {
//        User user = userService

        return null;
//        User user = new User();
//
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setRole(Role.STANDARD);
//
//        userService.createUser(user);
//
//        return ResponseEntity.ok(user);
    }
}
