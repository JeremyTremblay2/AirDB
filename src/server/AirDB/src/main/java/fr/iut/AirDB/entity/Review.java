package fr.iut.AirDB.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public record Review(
    ObjectId id,
    ObjectId authorId,
    String targetProfileId,
    String authorName,
    String profilePictureAuthor,
    LocalDate postedDate,
    String description,
    int satisfactionLevel
) {

}
