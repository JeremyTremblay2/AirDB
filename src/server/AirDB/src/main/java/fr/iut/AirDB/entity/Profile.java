package fr.iut.AirDB.entity;

import java.time.LocalDate;

public record Profile (
        String id,
        String[] housingIds,
        String profileName,
        LocalDate hostingSince,
        LocalDate dateOfBirth,
        String profilePicture,
        String location,
        String description
) {

}
