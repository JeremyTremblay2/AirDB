package fr.iut.AirDB.repository.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public record ReviewEntity(
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
