package fr.iut.AirDB.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public record Accommodation (
        ObjectId id,
        ObjectId profileId,
        String name,
        String[] pictures,
        float rating,
        int numberOfReviews,
        String location,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        String profileName,
        boolean isFavorite,
        HousingCategory[] housingCategories
) {

}
