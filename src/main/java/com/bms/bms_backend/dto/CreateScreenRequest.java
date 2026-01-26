package com.bms.bms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateScreenRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Theatre ID is required")
    private Long theatreId;
}
