package com.bms.bms_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Email(message = "Must be a valid email")
    @NotBlank(message = "Email is required")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;
}

// Client → Controller → Service → Repository → Database
