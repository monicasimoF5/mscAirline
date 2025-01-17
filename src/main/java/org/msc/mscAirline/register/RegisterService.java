package org.msc.mscAirline.register;

import org.msc.mscAirline.roles.RoleService;
import org.msc.mscAirline.users.User;
import org.msc.mscAirline.users.UserRequest;
import org.msc.mscAirline.users.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public RegisterService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public Map<String, String> save(UserRequest userRequest){
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(userRequest.password());
        String passwordDecoded = new String(decodedBytes);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoded = encoder.encode(passwordDecoded);

        User newUser = new User(userRequest.username(), passwordEncoded);
        newUser.setRoles(roleService.assignDefaultRole(1L)); //Pdte de revisar

        userRepository.save(newUser);

        Map<String, String> userResponse = new HashMap<>();
        userResponse.put("message", "Success");

        return userResponse;
    }
}
