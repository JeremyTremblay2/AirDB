package fr.iut.AirDB.services.accommodations;

import fr.iut.AirDB.converters.AccommodationModelDTOConverter;
import fr.iut.AirDB.converters.AccommodationModelEntityConverter;
import fr.iut.AirDB.converters.ProfileModelDTOConverter;
import fr.iut.AirDB.dto.AccommodationDTO;
import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.repository.AccommodationRepository;
import fr.iut.AirDB.repository.ProfileRepository;
import fr.iut.AirDB.repository.entity.AccommodationEntity;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class AccommodationService {
    protected AccommodationRepository repository;

    public AccommodationService(String collection, String connectionString, String databaseName) {
        repository = new AccommodationRepository(collection, connectionString, databaseName);
    }

    public AccommodationDTO getAccommodationById(String idProfile) {
        return AccommodationModelDTOConverter.modelToDTO(repository.getAccommodationById(idProfile));
    }

    public List<AccommodationDTO> getAccommodationsByName(String accommodationName) {
        return AccommodationModelDTOConverter.modelsToDTOs(repository.getAccommodationsByName(accommodationName));
    }

    public boolean addAccommodation(AccommodationDTO accommodationDTO) {
        return repository.addAccommodation(AccommodationModelDTOConverter.dtoToModel(accommodationDTO));
    }

    public boolean deleteAcommodation(String id){
        return repository.removeAccommodation(id);
    }

    public boolean updateAccommodation(AccommodationDTO accommodationDTO){
        return repository.updateAccommodation(AccommodationModelDTOConverter.dtoToModel(accommodationDTO));
    }

    public List<AccommodationDTO> getAccommodationsByFavorite(boolean isFavorite) {
        return AccommodationModelDTOConverter.modelsToDTOs(repository.getAccommodationsByFavorite(isFavorite));
    }

    public List<AccommodationDTO> getItems(int count, int page) {
        return AccommodationModelDTOConverter.modelsToDTOs(repository.getItems(count, page));
    }
}
