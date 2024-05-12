package com.reindefox.homelibraryserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Integer id;

    private String title;

    private String author;

    private Integer year;

    private String imageUrl;

    private String description;
}
