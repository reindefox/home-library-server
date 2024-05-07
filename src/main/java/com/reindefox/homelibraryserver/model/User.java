package com.reindefox.homelibraryserver.model;

import com.reindefox.homelibraryserver.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Getter
    @Setter
    @NonNull
    private String login;

    @Getter
    @Setter
    @NonNull
    private String password;

    @Getter
    @Setter
    private Role role = Role.STANDARD;

    @Getter
    @Setter
    private String[] readingNow;

    @Getter
    @Setter
    private String[] toRead;
}
