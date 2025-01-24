package org.msc.mscAirline.users;

import org.msc.mscAirline.roles.Role;

public record UserRequest(String username, String password, Role role) {
}
