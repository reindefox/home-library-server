package com.reindefox.homelibraryserver.model;

import com.reindefox.homelibraryserver.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Role role;

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role;
    }
}
