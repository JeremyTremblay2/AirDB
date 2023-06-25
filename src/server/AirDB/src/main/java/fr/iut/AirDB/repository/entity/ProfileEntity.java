package fr.iut.AirDB.repository.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfileEntity {
    public String id;
    public List<String> housingIds;
    public String profileName;
    public LocalDate hostingSince;
    public LocalDate dateOfBirth;
    public String profilePicture;
    public String location;
    public String description;
    public double rating;
    public int numberOfReviews;

    public ProfileEntity() {
        this(new String(), new ArrayList<String>(), "", LocalDate.now(), LocalDate.now(), "", "", "");
    }

    public ProfileEntity(String id, List<String> housingIds, String profileName, LocalDate hostingSince, LocalDate dateOfBirth, String profilePicture, String location, String description) {
        this.id = id;
        this.housingIds = housingIds;
        this.profileName = profileName;
        this.hostingSince = hostingSince;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
        this.location = location;
        this.description = description;
    }
}
