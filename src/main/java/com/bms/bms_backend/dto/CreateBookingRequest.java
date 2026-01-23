package com.bms.bms_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateBookingRequest {
    private Long userId;
    private Long showId;
    private List<Long> seatIds;
}
