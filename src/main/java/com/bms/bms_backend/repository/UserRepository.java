package com.bms.bms_backend.repository;

import com.bms.bms_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> id(long id); // Tells Spring Boot: manage the User entity with a primary key of type Long
    // No need to write any code here 👇
    // Spring Data JPA gives you methods automatically:
    // save(), findAll(), findById(), deleteById(), etc.
}
