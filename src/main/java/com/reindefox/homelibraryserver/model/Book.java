package com.reindefox.homelibraryserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "books")
@Entity
public class Book {
    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Заголовок
     */
    @Getter
    @Setter
    private String title;

    /**
     * Автор
     */
    @Getter
    @Setter
    private String author;

    /**
     * Год издания
     */
    @Getter
    @Setter
    private int year;

    /**
     * Ссылка на расположение обложки книги
     */
    @Getter
    @Setter
    private String imageUrl;

    /**
     * Описание
     */
    @Getter
    @Setter
    private String description;
}
