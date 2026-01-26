package com.bms.bms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTheatreRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Address is required")
    private String address;
}
