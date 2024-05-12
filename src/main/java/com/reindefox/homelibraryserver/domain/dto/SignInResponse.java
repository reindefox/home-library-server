package com.reindefox.homelibraryserver.domain.dto;

import com.reindefox.homelibraryserver.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponse {
    private String token;

    private String login;

    private Role role;
}