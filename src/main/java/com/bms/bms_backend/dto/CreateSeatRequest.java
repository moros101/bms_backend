package com.bms.bms_backend.dto;

import com.bms.bms_backend.model.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateSeatRequest {
    @NotBlank(message = "Seat number is required")
    private String seatNumber;
    @NotNull(message = "Seat type is required")
    private SeatType seatType;
    private boolean available;
    @NotNull(message = "Screen ID is required")
    private Long screenId;
}
