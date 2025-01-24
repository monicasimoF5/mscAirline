package org.msc.mscAirline.users;

import java.util.Set;

public class UserMapper {
    public static User toEntity(UserRequest userRequest){
        User newUser = new User();
        newUser.setUsername(userRequest.username());
        newUser.setPassword(userRequest.password());
        newUser.setRoles(Set.of(userRequest.role()));
        return newUser;
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
    }
}
