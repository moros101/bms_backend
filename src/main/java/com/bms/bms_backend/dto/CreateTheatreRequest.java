package com.bms.bms_backend.dto;

import lombok.Data;

@Data
public class CreateTheatreRequest {
    private String name;
    private String city;
    private String address;
}
