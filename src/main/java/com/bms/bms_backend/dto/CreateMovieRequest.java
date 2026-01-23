package com.bms.bms_backend.dto;

import lombok.Data;

@Data
public class CreateMovieRequest {
    private String title;
    private String language;
    private String genre;
    private int duration;
}
