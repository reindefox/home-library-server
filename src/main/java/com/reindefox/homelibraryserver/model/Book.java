package com.reindefox.homelibraryserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "books")
@Entity
public class Book {
    /**
     * Уникальный идентификатор
     */
    @Id
    private int id;

    /**
     * Заголовок
     */
    private String title;

    /**
     * Автор
     */
    private String author;

    /**
     * Год издания
     */
    private int year;

    /**
     * Ссылка на расположение обложки книги
     */
    private String imageUrl;

    /**
     * Описание
     */
    private String description;
}
