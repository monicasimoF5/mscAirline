package org.msc.mscAirline.profiles;

import org.msc.mscAirline.users.User;

public record ProfileResponse(
        Long id,
        String name,
        String phone,
        String picture/*,
        User user*/
) {
}
