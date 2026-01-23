package com.bms.bms_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ShowResponse {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double price;
//    private Long movieId;
    private String movieName;
//    private Long screenId;
    private String screenName;
}
