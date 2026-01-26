package com.bms.bms_backend.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class CreateShowRequest {
    @NotNull(message = "Start time is required")
    @Future(message = "Start time must be in future")
    private LocalDateTime startTime;
    @NotNull(message = "End time is required")
    @Future(message = "End time must be in future")
    private LocalDateTime endTime;
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be > 0")
    private double price;
    @NotNull(message = "Movie ID is required")
    private Long movieId;
    @NotNull(message = "Screen ID is required")
    private Long screenId;
}
