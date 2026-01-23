package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateUserRequest;
import com.bms.bms_backend.dto.UserResponse;
import com.bms.bms_backend.model.User;
import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, CreateUserRequest request);
    void deleteUser(Long id);
}
