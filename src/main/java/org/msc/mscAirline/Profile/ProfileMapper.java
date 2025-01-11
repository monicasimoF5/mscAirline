package org.msc.mscAirline.Profile;

import jakarta.validation.Valid;

public class ProfileMapper {
    public static Profile toEntity(@Valid ProfileRequest profileRequest){
        return new Profile(
                profileRequest.name(),
                profileRequest.email(),
                profileRequest.password(),
                profileRequest.picture(),
                profileRequest.rol()
        );
    }

    public static ProfileResponse toResponse(Profile profile){
        return new ProfileResponse(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getPassword(),
                profile.getPicture(),
                profile.getRol()
        );
    }

}
