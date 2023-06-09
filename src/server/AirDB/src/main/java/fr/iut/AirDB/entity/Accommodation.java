package fr.iut.AirDB.entity;

import java.time.LocalDate;

public record Accommodation (
        String id,
        String profileId,
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
