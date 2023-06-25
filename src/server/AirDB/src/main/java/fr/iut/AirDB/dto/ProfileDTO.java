package fr.iut.AirDB.dto;

import fr.iut.AirDB.modele.Accommodation;

import java.util.ArrayList;
import java.util.List;

public class ProfileDTO {

    private String _id;
    private List<Accommodation> housing;
    private String profilName;
    private String hostingSince;
    private String dateOfBirth;
    private String profilePicture;
    private String location;
    private String description;
    private double rating;
    private int numberOfReviews;

    public ProfileDTO() {
        this(new String(), new ArrayList<Accommodation>(), "", "", "", "", "", "");
    }

    public ProfileDTO(String _id, List<Accommodation> housing, String profilName, String hostingSince, String dateOfBirth, String profilePicture, String location, String description) {
        this._id = _id;
        this.housing = housing;
        this.profilName = profilName;
        this.hostingSince = hostingSince;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
        this.location = location;
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Accommodation> getHousing() {
        return housing;
    }

    public void setHousing(List<Accommodation> housing) {
        this.housing = housing;
    }

    public String getProfilName() {
        return profilName;
    }

    public void setProfilName(String profilName) {
        this.profilName = profilName;
    }

    public String getHostingSince() {
        return hostingSince;
    }

    public void setHostingSince(String hostingSince) {
        this.hostingSince = hostingSince;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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
