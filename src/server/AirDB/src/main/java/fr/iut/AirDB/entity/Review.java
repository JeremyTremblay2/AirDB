package fr.iut.AirDB.entity;

import java.time.LocalDate;

public record Review(
    String id,
    String authorId,
    String targetProfileId,
    String authorName,
    String profilePictureAuthor,
    LocalDate postedDate,
    String description,
    int satisfactionLevel
) {

}
