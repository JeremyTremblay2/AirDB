package fr.iut.AirDB.controllers;

import fr.iut.AirDB.services.profileservice.ProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @RequestMapping("/")
    public String home() {
        String uri = "mongodb://localhost:27017";
        ProfileService service = new ProfileService(uri, "local");
        var profile = service.GetProfileById("Iva Whitfield");
        return profile.profileName;
    }
}
