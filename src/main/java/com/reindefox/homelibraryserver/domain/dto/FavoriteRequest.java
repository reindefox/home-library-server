package com.reindefox.homelibraryserver.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FavoriteRequest {
    @JsonProperty("book_id")
    private Integer bookId;

    @JsonProperty("state")
    private boolean state;
}
