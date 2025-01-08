package org.msc.mscAirline.services;

import jakarta.validation.Valid;
import org.msc.mscAirline.dtos.UserRequest;
import org.msc.mscAirline.entities.User;
import org.msc.mscAirline.mappers.UserMapper;
import org.msc.mscAirline.repositories.UserRepository;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object createUser(@Valid UserRequest userRequest) throws AirlineAlreadyExistsException {
        Optional<User> existUser = userRepository.existsByEmail(userRequest.email());
        if (existUser.isPresent())
            throw new AirlineAlreadyExistsException("User already exist with this email.");

        User user = UserMapper.toEntity(userRequest);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }
}
