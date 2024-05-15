package com.reindefox.homelibraryserver.domain.dto;

import lombok.Data;

@Data
public class BookCreateRequest {
    private String title;

    private String author;

    private String imageUrl;

    private String description;
}
