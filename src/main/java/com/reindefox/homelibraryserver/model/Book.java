package com.reindefox.homelibraryserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Setter
    @NotNull
    private String title;

    @Setter
    @NotNull
    private String author;

    @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Setter
    @Column(columnDefinition = "text")
    private String description;

    @Setter
    @Column(columnDefinition = "text")
    private String content;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private Set<User> users = new HashSet<>();

    @PreRemove
    private void preRemove() {
        for (User user : users) {
            user.getBooks().remove(this);
        }
    }
}
