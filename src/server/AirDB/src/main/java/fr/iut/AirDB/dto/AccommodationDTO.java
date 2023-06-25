package fr.iut.AirDB.dto;


import fr.iut.AirDB.dto.embedded.ProfileEmbeddedDTO;
import fr.iut.AirDB.modele.HousingCategory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccommodationDTO {
    private String id;
    private String name;
    private List<String> pictures;
    private Double rating;
    private Integer numberOfReviews;
    private String location;
    private String description;
    private String startDate;
    private String endDate;
    private Boolean isFavorite;
    private List<HousingCategory> housingCategories;
    private ProfileEmbeddedDTO profileEmbeddedDTO;

    public AccommodationDTO() {
        this("", "", new ArrayList<>(), 0.0, 0, "", "",
                LocalDate.now().toString(), LocalDate.now().toString(), false, new ArrayList<>(), new ProfileEmbeddedDTO());
    }

    public AccommodationDTO(String id, String name, List<String> pictures, Double rating, Integer numberOfReviews,
                            String location, String description, String startDate, String endDate, Boolean isFavorite,
                            List<HousingCategory> housingCategories, ProfileEmbeddedDTO profileEmbeddedDTO) {
        this.id = id;
        this.name = name;
        this.pictures = pictures;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isFavorite = isFavorite;
        this.housingCategories = housingCategories;
        this.profileEmbeddedDTO = profileEmbeddedDTO;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPictures() {
        return Collections.unmodifiableList(pictures);
    }

    public Double getRating() {
        return rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public List<HousingCategory> getHousingCategories() {
        return Collections.unmodifiableList(housingCategories);
    }

    public ProfileEmbeddedDTO getProfileEmbeddedDTO() {
        return profileEmbeddedDTO;
    }
}
