package org.msc.mscAirline.config;

import org.msc.mscAirline.entities.Passenger;
import org.msc.mscAirline.repositories.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitFakeClass {

    @Bean
    public CommandLineRunner initUserData (PassengerRepository userRepository){
        return args -> {
            if (userRepository.count() == 0){
                List<Passenger> userList = List.of(
                        new Passenger("passenger1","passenger1@mscairline.com","@Pass1","picture1", Passenger.Rol.ROLE_USER),
                        new Passenger("passenger2","passenger2@mscairline.com","@Pass2","picture2", Passenger.Rol.ROLE_ADMIN)
                );
                userRepository.saveAll(userList);
            }
        };
    }
}
