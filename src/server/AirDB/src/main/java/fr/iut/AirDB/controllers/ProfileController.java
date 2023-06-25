package fr.iut.AirDB.controllers;

import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.services.profiles.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public ResponseEntity<ProfileDTO> GetProfileById(@PathVariable("urlParameter") String id) {
        try{
            var profile = service.GetProfileById(id);
            if(profile == null){
                return ResponseEntity.notFound().build();
            }
            else{
                return ResponseEntity.ok().body(profile);
            }
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/profiles/name/{urlParameter}")
    @ResponseBody
    public ResponseEntity<List<ProfileDTO>> GetProfilesByName(@PathVariable("urlParameter") String name) {
        try{
            var profiles = service.GetProfilesByName(name);
            return ResponseEntity.ok().body(profiles);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value="/profiles/add", method=RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addProfile(@RequestBody ProfileDTO profile) {
        try {
            var res = service.addProfile(profile);
            if(res){
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value="/profiles/remove/{urlParameter}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity removeProfile(@PathVariable("urlParameter") String id) {
        try{
            var res = service.deleteProfile(id);
            if(res){
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value="/profiles/update", method=RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updateProfile(@RequestBody ProfileDTO profile) {
        try {
            var res = service.updateProfile(profile);
            if(res){
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
