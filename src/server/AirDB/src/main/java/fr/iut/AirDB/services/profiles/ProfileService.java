package fr.iut.AirDB.services.profiles;

import fr.iut.AirDB.converters.ProfileModelDTOConverter;
import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.ProfileRepository;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ProfileService {

    protected ProfileRepository repository;

    public ProfileService(String collection, String connectionString, String databaseName) {
        repository = new ProfileRepository(collection, connectionString, databaseName);
    }

    public ProfileDTO GetProfileById(String idProfile){
        return ProfileModelDTOConverter.modelToDTO(repository.getProfileById(idProfile));
    }

    public List<ProfileDTO> GetProfilesByName(String nameProfile){
        return ProfileModelDTOConverter.modelsToDTOs(repository.getProfilesByName(nameProfile));
    }

    public boolean addProfile(ProfileDTO profile){
        return repository.addProfile(ProfileModelDTOConverter.dtoToModel(profile));
    }
}
