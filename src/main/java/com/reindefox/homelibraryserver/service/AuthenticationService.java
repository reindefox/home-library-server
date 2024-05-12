package com.reindefox.homelibraryserver.service;

import com.reindefox.homelibraryserver.domain.dto.SignInRequest;
import com.reindefox.homelibraryserver.domain.dto.SignInResponse;
import com.reindefox.homelibraryserver.domain.dto.SignUpRequest;
import com.reindefox.homelibraryserver.domain.dto.SignUpResponse;
import com.reindefox.homelibraryserver.enums.Role;
import com.reindefox.homelibraryserver.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public SignUpResponse signUp(SignUpRequest request) {
        var user = User.builder()
                .login(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userService.createUser(user);

        var jwt = jwtService.generateToken(user);

        return new SignUpResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public SignInResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);

        User userData = userService.findByLogin(request.getUsername());

        return new SignInResponse(jwt, userData.getLogin(), userData.getRole());
    }
}