package fr.iut.AirDB.converters;

import fr.iut.AirDB.dto.AccommodationDTO;
import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.dto.embedded.ProfileEmbeddedDTO;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.modele.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccommodationModelDTOConverter {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Accommodation dtoToModel(AccommodationDTO accommodation){
        var startDate = accommodation.getStartDate().split(" ")[0].replace("T", " ").split(" ")[0];
        var endDate = accommodation.getEndDate().split(" ")[0].replace("T", " ").split(" ")[0];
        return new Accommodation(accommodation.getId(), accommodation.getProfileEmbeddedDTO().getProfileId(),
                accommodation.getName(), accommodation.getPictures(), accommodation.getRating(), accommodation.getNumberOfReviews(),
                accommodation.getLocation(), accommodation.getDescription(), LocalDate.parse(startDate, formatter),
                LocalDate.parse(endDate, formatter), accommodation.getProfileEmbeddedDTO().getProfileName(),
                accommodation.getProfileEmbeddedDTO().getProfilePicture(),
                accommodation.getFavorite(), accommodation.getHousingCategories());
    }

    public static AccommodationDTO modelToDTO(Accommodation accommodation){
        return new AccommodationDTO(accommodation.getId(), accommodation.getName(), accommodation.getPictures(), accommodation.getRating(),
                accommodation.getNumberOfReviews(), accommodation.getLocation(), accommodation.getDescription(),
                accommodation.getStartDate().toString(), accommodation.getEndDate().toString(), accommodation.isFavorite(),
                accommodation.getHousingCategories(),
                new ProfileEmbeddedDTO(accommodation.getProfileId(), accommodation.getProfileName(), accommodation.getProfilePicture()));
    }

    public static List<Accommodation> dtosToModel(List<AccommodationDTO> accommodations){
        var pList = new ArrayList<Accommodation>();
        for(var accommodation : accommodations){
            pList.add(dtoToModel(accommodation));
        }
        return pList;
    }

    public static List<AccommodationDTO> modelsToDTOs(List<Accommodation> accommodations){
        var pList = new ArrayList<AccommodationDTO>();
        for(var accommodation : accommodations){
            pList.add(modelToDTO(accommodation));
        }
        return pList;
    }
}
