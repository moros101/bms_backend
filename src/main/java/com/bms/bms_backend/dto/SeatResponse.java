package com.bms.bms_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatResponse {
    private Long id;
    private String seatNumber;
    private String seatType;
    private boolean available;
    private String screenName;
    private Long screenId;
}
