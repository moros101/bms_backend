package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateUserRequest;
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
    public User createUser(CreateUserRequest request) {
        // convert request(DTO) -> entity object
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        // save to DB using JPA
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id : " + id));
    }

    @Override
    public User updateUser(Long id, CreateUserRequest request){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id : " + id));

        // update fields
        existingUser.setEmail(request.getEmail());
        existingUser.setName(request.getName());
        existingUser.setPhone(request.getPhone());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found with id : " + id);
        }
        userRepository.deleteById(id);
    }
}
