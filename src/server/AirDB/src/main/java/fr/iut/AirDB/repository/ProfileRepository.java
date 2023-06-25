package fr.iut.AirDB.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import fr.iut.AirDB.converters.ProfileModelEntityConverter;
import fr.iut.AirDB.entity.ProfileEntity;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.codecs.ProfileEntityCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

    public Profile getProfileById(String idProfile) {
        return ProfileModelEntityConverter.entityToModel(collection.find(Filters.eq("_id", idProfile)).first());
    }

    public List<Profile> getProfilesByName(String nameProfile){
        List<ProfileEntity> profileEntities = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*" + nameProfile + ".*", Pattern.CASE_INSENSITIVE);
        collection.find(Filters.regex("profilName", pattern)).into(profileEntities);
        return ProfileModelEntityConverter.entitiesToModel(profileEntities);
    }

    public boolean addProfile(Profile profile){
        return true;
    }
}
