package fr.iut.AirDB.services.profiles;

import fr.iut.AirDB.converters.ProfileModelDTOConverter;
import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.repository.ProfileRepository;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ProfileService {

    protected ProfileRepository repository;

    public ProfileService(String collection, String connectionString, String databaseName) {
        repository = new ProfileRepository(collection, connectionString, databaseName);
    }

    public ProfileDTO getProfileById(String idProfile){
        return ProfileModelDTOConverter.modelToDTO(repository.getProfileById(idProfile));
    }

    public List<ProfileDTO> getProfilesByName(String nameProfile){
        return ProfileModelDTOConverter.modelsToDTOs(repository.getProfilesByName(nameProfile));
    }

    public boolean addProfile(ProfileDTO profile){
        return repository.addProfile(ProfileModelDTOConverter.dtoToModel(profile));
    }

    public boolean deleteProfile(String id){
        return repository.removeProfile(id);
    }

    public boolean updateProfile(ProfileDTO profile){
        return repository.updateProfile(ProfileModelDTOConverter.dtoToModel(profile));
    }

    public void getProfileByMinimumRatingWithNumberOfHousing(){
        repository.getProfileByMinimumRatingWithNumberOfHousing(2); // just for the test. You can change the value if you want
    }
}
