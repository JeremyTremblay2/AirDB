package fr.iut.AirDB.controllers;

import fr.iut.AirDB.dto.AccommodationDTO;
import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.services.accommodations.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccommodationController {
    private static final String URI_MONGODB = "mongodb://localhost:27017";
    private static final String DATABASE = "local";
    private static final String COLLECTION = "profiles";

    private AccommodationService service = new AccommodationService(COLLECTION, URI_MONGODB, DATABASE);
    @GetMapping("/accommodations/id/{urlParameter}")
    @ResponseBody
    public ResponseEntity<AccommodationDTO> getAccommodationById(@PathVariable("urlParameter") String id) {
        try {
            var accommodation = service.getAccommodationById(id);
            if (accommodation == null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok().body(accommodation);
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/accommodations/name/{urlParameter}")
    @ResponseBody
    public ResponseEntity<List<AccommodationDTO>> getAccommodationsByName(@PathVariable("urlParameter") String name) {
        try {
            var profiles = service.getAccommodationsByName(name);
            return ResponseEntity.ok().body(profiles);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/accommodations/isFavorite/{urlParameter}")
    @ResponseBody
    public ResponseEntity<List<AccommodationDTO>> getAccommodationsByFavorite(@PathVariable("urlParameter") boolean isFavorite) {
        try {
            var profiles = service.getAccommodationsByFavorite(isFavorite);
            return ResponseEntity.ok().body(profiles);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/accommodations/get/{page}/{count}")
    @ResponseBody
    public ResponseEntity<List<AccommodationDTO>> getAccommodationsByFavorite(@PathVariable("page") int page, @PathVariable("count") int count) {
        try {
            var profiles = service.getItems(count, page);
            return ResponseEntity.ok().body(profiles);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value="/accommodations/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> addProfile(@RequestBody AccommodationDTO accommodation) {
        try {
            var res = service.addAccommodation(accommodation);
            if (res) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value="/accommodations/remove/{urlParameter}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> removeAccommodation(@PathVariable("urlParameter") String id) {
        try{
            var res = service.deleteAcommodation(id);
            if (res){
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value="/accommodations/update", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<?> updateProfile(@RequestBody AccommodationDTO accommodation) {
        try {
            var res = service.updateAccommodation(accommodation);
            if (res){
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
