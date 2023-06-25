package fr.iut.AirDB.controllers;

import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.services.profiles.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    private static final String URI_MONGODB = "mongodb://localhost:27017";
    private static final String DATABASE = "local";
    private static final String COLLECTION = "profiles";

    private ProfileService service = new ProfileService(COLLECTION, URI_MONGODB, DATABASE);
    @GetMapping("/profiles/id/{urlParameter}")
    @ResponseBody
    public ProfileDTO GetProfileById(@PathVariable("urlParameter") String id) {
        var profile = service.GetProfileById(id);
        return profile;
    }

    @GetMapping("/profiles/name/{urlParameter}")
    @ResponseBody
    public List<ProfileDTO> GetProfilesByName(@PathVariable("urlParameter") String name) {
        var profiles = service.GetProfilesByName(name);
        return profiles;
    }

    @PostMapping("/profiles/add")
    @ResponseBody
    public void getFoos(@RequestParam ProfileDTO profile) {
        service.addProfile(profile);
    }
}
