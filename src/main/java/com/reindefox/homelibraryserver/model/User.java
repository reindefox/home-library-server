package com.reindefox.homelibraryserver.model;

import com.reindefox.homelibraryserver.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

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
    @ElementCollection
    private List<String> readingNow;

    @Getter
    @Setter
    @ElementCollection
    private List<String> toRead;
}
