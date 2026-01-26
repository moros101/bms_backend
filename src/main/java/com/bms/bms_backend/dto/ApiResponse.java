package com.bms.bms_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse<T> { // generic class
    private String status;  // success | failure
    private String message; // readable message
    private T data;         // generic data
    private LocalDateTime timeStamp;
}
