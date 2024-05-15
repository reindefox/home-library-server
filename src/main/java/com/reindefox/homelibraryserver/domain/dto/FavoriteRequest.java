package com.reindefox.homelibraryserver.domain.dto;

import lombok.Data;

@Data
public class FavoriteRequest {
    private Integer bookId;

    private boolean state;
}
