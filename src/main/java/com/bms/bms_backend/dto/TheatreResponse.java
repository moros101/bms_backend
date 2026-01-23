package com.bms.bms_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponse {
    private Long id;
    private String name;
    private String city;
    private String address;
}
