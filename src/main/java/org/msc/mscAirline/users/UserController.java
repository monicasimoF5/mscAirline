package org.msc.mscAirline.users;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

    @RestController
    @RequestMapping("/api/v1/users")
    public class UserController {
        private final UserService userService;
        private UserRepository userRepository;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public ResponseEntity<UserResponse> addUser(@RequestBody @Valid UserRequest userRequestDTO){
            UserResponse userResponseDTO = userService.createUser(userRequestDTO);
            return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
            UserResponse userResponseDTO = userService.findUserById(id);
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        }

        @GetMapping
        public List<UserResponse> getUserByName(@PathParam("username") String name){
            try{
                Long profileId = Long.parseLong((name));
                return Collections.singletonList(userService.findUserById(profileId));
            } catch (NumberFormatException exception){
                return userService.findUserByUsername(name);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userRequestDTO){
            UserResponse userResponseDTO = userService.updateUserById(id, userRequestDTO);
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUserById(@PathVariable Long id){
            userService.deleteUserById(id);
            return new ResponseEntity<>("The user has been eliminated", HttpStatus.OK);
        }

    }

