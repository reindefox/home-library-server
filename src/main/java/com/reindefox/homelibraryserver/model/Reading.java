package com.reindefox.homelibraryserver.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "reading")
public class Reading {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @NotNull
    private User user;

    @ManyToMany
    @NotNull
    private Book book;
}
