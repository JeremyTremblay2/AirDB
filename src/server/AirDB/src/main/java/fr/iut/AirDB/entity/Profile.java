package fr.iut.AirDB.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public record Profile (
        ObjectId id,
        ObjectId[] housingIds,
        String profileName,
        LocalDate hostingSince,
        LocalDate dateOfBirth,
        String profilePicture,
        String location,
        String description
) {

}
