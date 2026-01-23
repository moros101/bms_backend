package com.bms.bms_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookingResponse {
    private Long id;
    private String userName;
    private String movieTitle;
    private String screenName;
    private List<String> seatNumbers;
    private double totalAmount;
    private LocalDateTime bookingTime;
    private String status;
}
