/*package org.msc.mscAirline.config;

import org.msc.mscAirline.profiles.Profile;
import org.msc.mscAirline.profiles.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitFakeClass {

    @Bean
    public CommandLineRunner initUserData (ProfileRepository userRepository){
        return args -> {
            if (userRepository.count() == 0){
                List<Profile> profileList = List.of(
                        new Profile("passenger1","passenger1@mscairline.com","@Pass1","picture1", Profile.Rol.ROLE_USER),
                        new Profile("passenger2","passenger2@mscairline.com","@Pass2","picture2", Profile.Rol.ROLE_ADMIN)
                );
                userRepository.saveAll(profileList);
            }
        };
    }
}*/
