package com.bms.bms_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateSeatRequest {
    private String seatNumber;
    private String seatType;
    private boolean available;
    private Long screenId;
}
