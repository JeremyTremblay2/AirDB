package fr.iut.AirDB.services.profiles;

import fr.iut.AirDB.entity.ProfileEntity;
import fr.iut.AirDB.repository.ProfileRepository;

import static com.mongodb.client.model.Filters.eq;

public class ProfileService {

    protected ProfileRepository repository;

    public ProfileService(String collection, String connectionString, String databaseName) {
        repository = new ProfileRepository(collection, connectionString, databaseName);
    }

    public ProfileEntity GetProfileById(String idProfile){
        return repository.GetProfileById(idProfile);
    }

}
