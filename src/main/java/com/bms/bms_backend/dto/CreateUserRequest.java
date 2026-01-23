package com.bms.bms_backend.dto;

import lombok.Data;
@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String phone;
}

// Client → Controller → Service → Repository → Database
