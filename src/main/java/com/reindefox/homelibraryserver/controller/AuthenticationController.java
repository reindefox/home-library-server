package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.controller.model.UserBody;
import com.reindefox.homelibraryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserBody user) {
        if (userService.findByLogin(user.getLogin()) != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("status", ErrorCode.ALREADY_EXISTS.toString()));
        }

        return new ResponseEntity<>(Collections.singletonMap("token", "123"), HttpStatus.OK);
    }

    public enum ErrorCode {
        ALREADY_EXISTS
    }
}
