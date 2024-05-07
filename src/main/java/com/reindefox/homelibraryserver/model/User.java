package com.reindefox.homelibraryserver.model;

import com.reindefox.homelibraryserver.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
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

    @Getter
    @Setter
    private int[] readingNow;

    @Getter
    @Setter
    private int[] toRead;
}
