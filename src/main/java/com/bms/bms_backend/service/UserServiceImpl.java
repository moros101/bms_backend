package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateUserRequest;
import com.bms.bms_backend.dto.UserResponse;
import com.bms.bms_backend.model.User;
import com.bms.bms_backend.repository.UserRepository;
import com.bms.bms_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        // convert request(DTO) -> entity object
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        // save to DB using JPA
        User saved = userRepository.save(user);
        return convertToResponse(saved);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id : " + id));
        return convertToResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, CreateUserRequest request){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id : " + id));

        // update fields
        existingUser.setEmail(request.getEmail());
        existingUser.setName(request.getName());
        existingUser.setPhone(request.getPhone());

        User saved =  userRepository.save(existingUser);
        return convertToResponse(saved);
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found with id : " + id);
        }
        userRepository.deleteById(id);
    }

    private UserResponse convertToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getName())
                .phone(user.getName())
                .build();
    }
}
