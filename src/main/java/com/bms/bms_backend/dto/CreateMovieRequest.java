package com.bms.bms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateMovieRequest {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Language is required")
    private String language;
    @NotBlank(message = "Genre is required")
    private String genre;
    @Positive(message = "Duration must be positive")
    private int duration;
}
