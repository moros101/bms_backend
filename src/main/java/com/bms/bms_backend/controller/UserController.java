package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.CreateUserRequest;
import com.bms.bms_backend.dto.UserResponse;
import com.bms.bms_backend.model.User;
import com.bms.bms_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController // marks class as restAPI handler
@RequestMapping("bms/v1/users") // base path -> all endpoints starts with /users
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // create new user (POST /users)
    @PostMapping // map HTTP method
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request){
        // binds JSON requestBody -> java object(create user request
        return userService.createUser(request);
    }
    // get all users (GET /users)
    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
    // get single user (GET /users/{id})
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody CreateUserRequest request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Deleted Successfully!";
    }
}