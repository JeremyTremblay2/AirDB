package fr.iut.AirDB.modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profile {

    private String id;
    private List<Accommodation> housing;
    private String profileName;
    private LocalDate hostingSince;
    private LocalDate dateOfBirth;
    private String profilePicture;
    private String location;
    private String description;
    private double rating;
    private int numberOfReviews;

    public Profile() {
        this(new String(), new ArrayList<Accommodation>(), "", LocalDate.now(), LocalDate.now(), "", "", "");
    }

    public Profile(String id, List<Accommodation> housing, String profileName, LocalDate hostingSince, LocalDate dateOfBirth, String profilePicture, String location, String description) {
        this.id = id;
        this.housing = housing;
        this.profileName = profileName;
        this.hostingSince = hostingSince;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
        this.location = location;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Accommodation> getHousing() {
        return housing;
    }

    public void setHousing(List<Accommodation> housing) {
        this.housing = housing;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public LocalDate getHostingSince() {
        return hostingSince;
    }

    public void setHostingSince(LocalDate hostingSince) {
        this.hostingSince = hostingSince;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }
}
