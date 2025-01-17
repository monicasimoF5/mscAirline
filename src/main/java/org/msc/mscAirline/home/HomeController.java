package org.msc.mscAirline.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-endpoint}")
public class HomeController {

    @GetMapping("")
    public String index(){
        return "Welcome to server!";
    }

    @GetMapping("/public")
    public String gotToPublic(){
        return "Public path...";
    }

    @GetMapping("/private")
    public String goToPrivate(){
        return "Private path...";
    }
}
