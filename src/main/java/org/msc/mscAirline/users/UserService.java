package org.msc.mscAirline.users;

import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest){
        User user = UserMapper.toEntity(userRequest);
        return UserMapper.toResponse(userRepository.save(user));
    }

    public List<UserResponse> findAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper::toResponse).toList();
    }

    public UserResponse findUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new AirlineNotFoundException("The user with id " + id + "does not exist.");
        }
        User user = optionalUser.get();
        return UserMapper.toResponse(user);
    }

    public List<UserResponse> findUserByUsername(String username){
        List<User> users = userRepository.findUserByUsername(username);

        if(users.isEmpty()){
            throw new AirlineNotFoundException("The user with the username" + username + "does not exist.");
        }
        return users.stream()
                .map(UserMapper::toResponse).toList();
    }

}
