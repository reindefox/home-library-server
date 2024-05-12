package com.reindefox.homelibraryserver.domain.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String username;

    private String password;
}