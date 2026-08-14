package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest) {
        User user= User.builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())

                .build();

//        User user = new User(
//                null,
//                registerRequest.getEmail(),
//                registerRequest.getPassword(),
//                registerRequest.getFirstName(),
//                registerRequest.getLastName(),
//                Instant.parse("2025-12-08T14:49:41.208Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2025-12-08T14:49:41.208Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                List.of(),
//                List.of()
//        );

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {

        UserResponse response = new UserResponse();

        response.setId(String.valueOf(savedUser.getId()));
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedDate(LocalDate.from(savedUser.getCreatedDate()));
        response.setUpdatedDate(LocalTime.from(savedUser.getUpdatedDate()));

        return response;
    }
}