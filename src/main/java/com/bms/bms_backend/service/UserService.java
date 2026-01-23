package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateUserRequest;
import com.bms.bms_backend.model.User;
import java.util.List;

public interface UserService {
    User createUser(CreateUserRequest request);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, CreateUserRequest request);
    void deleteUser(Long id);
}
