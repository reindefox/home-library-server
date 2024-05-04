package com.reindefox.homelibraryserver.model;

import com.reindefox.homelibraryserver.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;

    private String login;

    private String password;

    private Role role;
}
