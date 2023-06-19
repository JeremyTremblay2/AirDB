package fr.iut.AirDB.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class ProfileEntity {
    public String id;
    public String[] housingIds;
    public String profileName;
    public LocalDate hostingSince;
    public LocalDate dateOfBirth;
    public String profilePicture;
    public String location;
    public String description;

    public ProfileEntity() {
        this(new String(), new String[]{}, "", LocalDate.now(), LocalDate.now(), "", "", "");
    }

    public ProfileEntity(String id, String[] housingIds, String profileName, LocalDate hostingSince, LocalDate dateOfBirth, String profilePicture, String location, String description) {
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
