package org.msc.mscAirline.Profile;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@RequestBody @Valid ProfileRequest profileRequest) throws AirlineAlreadyExistsException {
        ProfileResponse user = (ProfileResponse) profileService.createProfile(profileRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> getProfileById(@PathVariable Long id){
        ProfileResponse profileResponse = profileService.findById(id);
        return new ResponseEntity<>(profileResponse, HttpStatus.OK);
    }

    @GetMapping
    public List<ProfileResponse> getProfileByEmail(@PathParam("email") String email){
        if (email == null){
            return profileService.findAll();
        }
        return profileService.findByEmailIgnoreCaseContaining(email);
    }

}
