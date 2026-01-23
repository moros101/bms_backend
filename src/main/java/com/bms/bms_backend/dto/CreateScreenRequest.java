package com.bms.bms_backend.dto;

import lombok.Data;

@Data
public class CreateScreenRequest {
    private String name;
    private Long theatreId;
}
