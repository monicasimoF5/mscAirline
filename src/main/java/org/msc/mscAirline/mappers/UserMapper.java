package org.msc.mscAirline.mappers;

import jakarta.validation.Valid;
import org.msc.mscAirline.dtos.UserRequest;
import org.msc.mscAirline.dtos.UserResponse;
import org.msc.mscAirline.entities.User;

public class UserMapper {
    public static User toEntity(@Valid UserRequest userRequest){
        return new User(
                userRequest.name(),
                userRequest.email(),
                userRequest.password(),
                userRequest.picture(),
                userRequest.rol()
        );
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPicture(),
                user.getRol()
        );
    }

}
