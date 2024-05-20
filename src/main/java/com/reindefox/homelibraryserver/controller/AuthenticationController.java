package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.domain.dto.SignInRequest;
import com.reindefox.homelibraryserver.domain.dto.SignInResponse;
import com.reindefox.homelibraryserver.domain.dto.SignUpRequest;
import com.reindefox.homelibraryserver.domain.dto.SignUpResponse;
import com.reindefox.homelibraryserver.model.User;
import com.reindefox.homelibraryserver.service.AuthenticationService;
import com.reindefox.homelibraryserver.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Запрос создания авторизации пользователя
     * @param request данные авторизации
     * @return JWT, логин и роль пользователя
     */
    @PostMapping(value = "/login")
    public SignInResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

    /**
     * Запрос регистрации пользователя
     * @param request данные для регистрации
     * @return JWT
     */
    @PostMapping(value = "/reg")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody @Valid SignUpRequest request) {
        User user = userService.findByLogin(request.getUsername());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authenticationService.signUp(request));
    }
}
