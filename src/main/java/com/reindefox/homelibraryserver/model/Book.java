package com.reindefox.homelibraryserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    @Getter
    private int id;

    @Getter
    @Setter
    @NotNull
    private String title;

    @Getter
    @Setter
    @NotNull
    private String author;

    @Getter
    @Setter
    private int year;

    @Getter
    @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter
    @Setter
    @Column(columnDefinition = "text")
    private String description;
}
