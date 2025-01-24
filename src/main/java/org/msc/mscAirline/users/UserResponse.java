package org.msc.mscAirline.users;

import org.msc.mscAirline.roles.Role;

import java.util.Set;

public record UserResponse(
        Long id,
        String username,
        String password,
        Set<Role> roles) {
}
