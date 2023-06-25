package fr.iut.AirDB.repository.codecs;

import com.mongodb.MongoClientSettings;
import fr.iut.AirDB.repository.entity.AccommodationEntity;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AccommodationCodec implements Codec<AccommodationEntity> {
    private final Codec<Document> documentCodec;

    public AccommodationCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public AccommodationEntity decode(BsonReader bsonReader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(bsonReader, decoderContext);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var startDate = document.getString("startDate");
        startDate = startDate.split(" ")[0].replace("T", " ").split(" ")[0];
        var endDate = document.getString("endDate");
        endDate = endDate.split(" ")[0].replace("T", " ").split(" ")[0];
        AccommodationEntity accommodation = new AccommodationEntity(
                document.getString("_id"),
                document.getString("profileId"),
                document.getString("name"),
                document.getList("pictures", String.class),
                document.getDouble("rating"),
                document.getInteger("numberOfReviews"),
                document.getString("location"),
                document.getString("description"),
                LocalDate.parse(startDate, formatter),
                LocalDate.parse(endDate, formatter),
                "",
                "",
                document.getBoolean("isFavorite"),
                document.getList("housingCategory", String.class)
        );
        return accommodation;
    }

    @Override
    public void encode(BsonWriter bsonWriter, AccommodationEntity accommodation, EncoderContext encoderContext) {
        Document doc = new Document();
        doc.put("_id", accommodation.getId());
        doc.put("profileId", accommodation.getProfileId());
        doc.put("name", accommodation.getName());
        doc.put("pictures", accommodation.getPictures());
        doc.put("rating", accommodation.getRating());
        doc.put("numberOfReviews", accommodation.getNumberOfReviews());
        doc.put("location", accommodation.getLocation());
        doc.put("description", accommodation.getDescription());
        doc.put("startDate", accommodation.getStartDate());
        doc.put("endDate", accommodation.getEndDate());
        doc.put("isFavorite", accommodation.isFavorite());
        doc.put("housingCategories", accommodation.getHousingCategories());
        documentCodec.encode(bsonWriter, doc, encoderContext);
    }

    @Override
    public Class<AccommodationEntity> getEncoderClass() {
        return AccommodationEntity.class;
    }
}
