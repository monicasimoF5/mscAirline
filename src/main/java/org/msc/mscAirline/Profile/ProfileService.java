package org.msc.mscAirline.Profile;

import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Object createProfile(ProfileRequest profileRequest) throws AirlineAlreadyExistsException {
        Optional<Profile> findProfile = profileRepository.findByEmail(profileRequest.email());
        if (findProfile.isPresent())
            throw new AirlineAlreadyExistsException("Profile already exist with this email.");

        Profile profile = ProfileMapper.toEntity(profileRequest);
        Profile savedProfile = profileRepository.save(profile);
        return ProfileMapper.toResponse(savedProfile);
    }

    public ProfileResponse findById(Long id) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);

        if (optionalProfile.isEmpty()){
            throw new AirlineNotFoundException("The profile with id " + id + " does not exist.");
        }

        Profile profile = optionalProfile.get();
        return ProfileMapper.toResponse(profile);
    }

    public List<ProfileResponse> findAll (){
        List<Profile> profileList = profileRepository.findAll();
        return profileList.stream()
                .map(ProfileMapper::toResponse).toList();
    }


    public List<ProfileResponse> findByEmailIgnoreCaseContaining(String email) {
        List<Profile> profileList = profileRepository.findByEmailIgnoreCaseContaining(email);

        if (profileList.isEmpty()){
            throw new AirlineNotFoundException("The profile with email " + email + " does not exist.");
        }
        return profileList.stream()
                .map(ProfileMapper::toResponse).toList();
    }
}
