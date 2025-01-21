package org.msc.mscAirline.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class AuthenticationController {

    @GetMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login(){

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication authentication = contextHolder.getAuthentication();

        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("username", authentication.getName());
        json.put("roles", authentication.getAuthorities().iterator().next().toString());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}
