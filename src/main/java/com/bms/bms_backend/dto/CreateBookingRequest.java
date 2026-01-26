package com.bms.bms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateBookingRequest {
    @NotNull(message = "User ID is required")
    private Long userId;
    @NotNull(message = "Show ID is required")
    private Long showId;
    @NotNull(message = "Seat list cannot be empty")
    @Size(message = "At least 1 seat must be selected")
    private List<@NotNull(message = "Seat ID is required") Long> seatIds;
}
