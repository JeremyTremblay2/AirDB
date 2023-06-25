package fr.iut.AirDB.modele;

import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.*;

public class Accommodation {
    private String id;
    private String profileId;
    private String name;
    private List<String> pictures;
    private Double rating;
    private Integer numberOfReviews;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String profileName;
    private String profilePicture;
    private Boolean isFavorite;
    private List<HousingCategory> housingCategories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Boolean isFavorite() {
        return isFavorite;
    }

    public List<HousingCategory> getHousingCategories() {
        return Collections.unmodifiableList(housingCategories);
    }

    public Accommodation() {
        this("", "", "", new ArrayList<>(), 0.0, 0, "", "",
                LocalDate.now(), LocalDate.now(), "", "", false, new ArrayList<>());
    }

    public Accommodation(String id, String profileId, String name, List<String> pictures, Double rating, Integer numberOfReviews,
                         String location, String description, LocalDate startDate, LocalDate endDate, String profileName,
                         String profilePicture, Boolean isFavorite, List<HousingCategory> housingCategories) {
        this.id = id;
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
        this.profilePicture = profilePicture;
        this.isFavorite = isFavorite;
        this.housingCategories = housingCategories;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", profileId=" + profileId +
                ", name='" + name + '\'' +
                ", pictures=" + pictures +
                ", rating=" + rating +
                ", numberOfReviews=" + numberOfReviews +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", profileName='" + profileName + '\'' +
                ", isFavorite=" + isFavorite +
                ", housingCategories=" + housingCategories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
