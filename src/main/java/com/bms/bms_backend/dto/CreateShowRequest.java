package com.bms.bms_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateShowRequest {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double price;
    private Long movieId;
    private Long screenId;
}
