package fr.iut.AirDB.services.profiles;

import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.ProfileRepository;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ProfileService {

    protected ProfileRepository repository;

    public ProfileService(String collection, String connectionString, String databaseName) {
        repository = new ProfileRepository(collection, connectionString, databaseName);
    }

    public Profile GetProfileById(String idProfile){
        return repository.getProfileById(idProfile);
    }

    public List<Profile> GetProfilesByName(String nameProfile){
        return repository.getProfilesByName(nameProfile);
    }

}
