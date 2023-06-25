package fr.iut.AirDB.repository.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class AccommodationEntity extends GenericEntity {
    private ObjectId profileId;
    private String name;
    private List<String> pictures;
    private Double rating;
    private Integer numberOfReviews;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String profileName;
    private Boolean isFavorite;
    private List<String> housingCategories;

    public AccommodationEntity(ObjectId id, ObjectId profileId, String name, List<String> pictures, Double rating,
                               Integer numberOfReviews, String location, String description, LocalDate startDate,
                               LocalDate endDate, String profileName, Boolean isFavorite, List<String> housingCategories) {
        super(id);
        this.profileId = profileId;
        this.name = name;
        this.pictures = pictures;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.profileName = profileName;
        this.isFavorite = isFavorite;
        this.housingCategories = housingCategories;
    }

    public ObjectId getProfileId() {
        return profileId;
    }

    public void setProfileId(ObjectId profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public List<String> getHousingCategories() {
        return housingCategories;
    }

    public void setHousingCategories(List<String> housingCategories) {
        this.housingCategories = housingCategories;
    }
}
