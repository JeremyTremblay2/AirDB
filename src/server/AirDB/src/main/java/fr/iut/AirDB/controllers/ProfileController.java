package fr.iut.AirDB.controllers;

import fr.iut.AirDB.services.profiles.ProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @RequestMapping("/")
    public String home() {
        String uri = "mongodb://localhost:27017";
        ProfileService service = new ProfileService("profiles", uri, "local");
        var profile = service.GetProfileById("6470526076115afa0b257e9e");
        return profile.profileName;
    }
}
