package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Получение пользователя по id
     * @param id id пользователя
     * @return пользователь
     */
    @RequestMapping("/get/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        User user = userService.getById(id);

        if (user != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение пользователя по логину
     * @param login логин пользователя
     * @return пользователь
     */
    @RequestMapping("/find/{login}")
    public ResponseEntity<User> findByLogin(@PathVariable String login) {
        User user = userService.findByLogin(login);

        if (user != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
