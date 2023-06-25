package fr.iut.AirDB.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import fr.iut.AirDB.converters.AccommodationModelEntityConverter;
import fr.iut.AirDB.converters.ProfileModelEntityConverter;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.codecs.AccommodationCodec;
import fr.iut.AirDB.repository.codecs.AccommodationCodecProvider;
import fr.iut.AirDB.repository.codecs.ProfileEntityCodec;
import fr.iut.AirDB.repository.entity.AccommodationEntity;
import fr.iut.AirDB.repository.entity.ProfileEntity;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;

public class AccommodationRepository extends AirDBRepository {
    private final MongoCollection<AccommodationEntity> collection;

    public AccommodationRepository(String collection, String connectionString, String databaseName) {
        super(collection, connectionString, databaseName);
        CodecRegistry registry = CodecRegistries.fromCodecs(new AccommodationCodec());
        CodecRegistry customCodecRegistry = CodecRegistries.fromRegistries(
                registry,
                MongoClientSettings.getDefaultCodecRegistry());
        this.collection = database.getCollection(collection, AccommodationEntity.class).withCodecRegistry(customCodecRegistry);
    }

    public Accommodation getAccommodationById(String idAccommodation) {
        return AccommodationModelEntityConverter.entityToModel(collection.find(eq("_id", idAccommodation)).first());
    }

    public List<Accommodation> getAccommodationsByName(String accommodationName) {
        List<AccommodationEntity> accommodationEntities = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*" + accommodationName + ".*", Pattern.CASE_INSENSITIVE);
        collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.regex("name", pattern))
                )
        ).into(accommodationEntities);
        return AccommodationModelEntityConverter.entitiesToModel(accommodationEntities);
    }

    public boolean addAccommodation(Accommodation accommodation) {
        try {
            accommodation.setId(new ObjectId().toString());
            collection.insertOne(AccommodationModelEntityConverter.modelToEntity(accommodation));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeAccommodation(String id) {
        try {
            collection.deleteOne(eq("_id", id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateAccommodation(Accommodation accommodation) {
        try {
            Bson query = eq("_id", accommodation.getId());
            collection.replaceOne(query, AccommodationModelEntityConverter.modelToEntity(accommodation));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Accommodation> getAccommodationsByFavorite(boolean isFavorite) {
        List<AccommodationEntity> accommodationEntities = new ArrayList<>();
        collection.find(eq("isFavorite", isFavorite))
                .iterator()
                .forEachRemaining(accommodationEntities::add);
        return AccommodationModelEntityConverter.entitiesToModel(accommodationEntities);
    }

    public List<AccommodationEntity> getItems(int count, int page) {
        List<AccommodationEntity> accommodations = new ArrayList<>();

        Bson filter = new Document();
        int skip = (page - 1) * count;

        collection.find(filter)
                .limit(count)
                .skip(skip)
                .iterator()
                .forEachRemaining(accommodations::add);

        return accommodations;
    }
}
