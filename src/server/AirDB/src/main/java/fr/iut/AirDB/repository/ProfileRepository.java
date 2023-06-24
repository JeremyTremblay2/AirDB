package fr.iut.AirDB.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.iut.AirDB.entity.AccommodationEntity;
import fr.iut.AirDB.entity.ProfileEntity;
import fr.iut.AirDB.repository.codecs.accommodations.AccommodationCodecProvider;
import fr.iut.AirDB.repository.mappers.profile_mappers.ProfileEntityCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.ArrayList;
import java.util.List;

public class ProfileRepository extends AirDBRepository{

    private final MongoCollection<ProfileEntity> collection;

    public ProfileRepository(String collection, String connectionString, String databaseName) {
        super(collection, connectionString, databaseName);
        CodecRegistry registry = CodecRegistries.fromCodecs(new ProfileEntityCodec());
        CodecRegistry customCodecRegistry = CodecRegistries.fromRegistries(
                registry,
                MongoClientSettings.getDefaultCodecRegistry());
        this.collection = database.getCollection(collection, ProfileEntity.class).withCodecRegistry(customCodecRegistry);
    }

    public ProfileEntity GetProfileById(String idProfile) {
        return collection.find().first();
    }
}
