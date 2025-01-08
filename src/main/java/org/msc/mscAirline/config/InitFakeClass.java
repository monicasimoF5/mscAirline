package org.msc.mscAirline.config;

import org.msc.mscAirline.entities.User;
import org.msc.mscAirline.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitFakeClass {

    @Bean
    public CommandLineRunner initUserData (UserRepository userRepository){
        return args -> {
            if (userRepository.count() == 0){
                List<User> userList = List.of(
                        new User("user1","email1@mscairline.com","@User1","picture1", User.Rol.ROLE_USER),
                        new User("user2","email2@mscairline.com","@User2","picture2", User.Rol.ROLE_USER)
                );
                userRepository.saveAll(userList);
            }
        };
    }
}
