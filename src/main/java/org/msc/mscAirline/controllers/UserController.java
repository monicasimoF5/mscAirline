package org.msc.mscAirline.controllers;

import jakarta.validation.Valid;
import org.msc.mscAirline.dtos.UserRequest;
import org.msc.mscAirline.dtos.UserResponse;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.msc.mscAirline.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) throws AirlineAlreadyExistsException {
        UserResponse user = (UserResponse) userService.createUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
