package fr.iut.AirDB.converters;

import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.modele.HousingCategory;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.entity.AccommodationEntity;
import fr.iut.AirDB.repository.entity.ProfileEntity;

import java.util.ArrayList;
import java.util.List;

public class AccommodationModelEntityConverter {
    public static Accommodation entityToModel(AccommodationEntity accommodation){
        return new Accommodation(accommodation.getId(), accommodation.getProfileId(), accommodation.getName(), accommodation.getPictures(),
                accommodation.getRating(), accommodation.getNumberOfReviews(), accommodation.getLocation(),
                accommodation.getDescription(), accommodation.getStartDate(), accommodation.getEndDate(),
                accommodation.getProfileName(), accommodation.getProfilePicture(), accommodation.isFavorite(),
                stringToHousingCategories(accommodation.getHousingCategories()));
    }

    public static AccommodationEntity modelToEntity(Accommodation accommodation){
        AccommodationEntity accommodationEntity = new AccommodationEntity();
        accommodationEntity.setId(accommodation.getId());
        accommodationEntity.setProfileId(accommodation.getProfileId());
        accommodationEntity.setName(accommodation.getName());
        accommodationEntity.setPictures(accommodation.getPictures());
        accommodationEntity.setRating(accommodation.getRating());
        accommodationEntity.setNumberOfReviews(accommodation.getNumberOfReviews());
        accommodationEntity.setLocation(accommodation.getLocation());
        accommodationEntity.setDescription(accommodation.getDescription());
        accommodationEntity.setStartDate(accommodation.getStartDate());
        accommodationEntity.setEndDate(accommodation.getEndDate());
        accommodationEntity.setProfilePicture(accommodation.getProfilePicture());
        accommodationEntity.setProfileName(accommodation.getProfileName());
        accommodationEntity.setFavorite(accommodation.isFavorite());
        accommodationEntity.setHousingCategories(housingCategoiesToString(accommodation.getHousingCategories()));
        return accommodationEntity;
    }

    public static List<Accommodation> entitiesToModel(List<AccommodationEntity> accommodations){
        var pList = new ArrayList<Accommodation>();
        for(var accommodation : accommodations){
            pList.add(entityToModel(accommodation));
        }
        return pList;
    }

    public static List<AccommodationEntity> modelsToEntities(List<Accommodation> accommodations){
        var pList = new ArrayList<AccommodationEntity>();
        for(var accommodation : accommodations){
            pList.add(modelToEntity(accommodation));
        }
        return pList;
    }

    public static List<String> housingCategoiesToString(List<HousingCategory> housingCategories){
        var pList = new ArrayList<String>();
        for(var housingCategory : housingCategories){
            pList.add(maphousingCategoryToString(housingCategory));
        }
        return pList;
    }

    public static List<HousingCategory> stringToHousingCategories(List<String> housingCategories){
        var pList = new ArrayList<HousingCategory>();
        for(var housingCategory : housingCategories){
            pList.add(mapStringToHousingCategory(housingCategory));
        }
        return pList;
    }

    public static HousingCategory mapStringToHousingCategory(String housingCategoryString) {
        try {
            return HousingCategory.valueOf(housingCategoryString);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static String maphousingCategoryToString(HousingCategory housingCategory) {
        return housingCategory.toString();
    }
}
