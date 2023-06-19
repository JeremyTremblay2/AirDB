package fr.iut.AirDB.services.profileservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.iut.AirDB.entity.ProfileEntity;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.mappers.profile_mappers.ProfileCodecProvider;
import fr.iut.AirDB.repository.mappers.profile_mappers.ProfileEntityCodec;
import fr.iut.AirDB.services.BaseService;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.json.JsonObject;
import org.bson.types.Code;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ProfileService extends BaseService {

    public ProfileService(String connectionString, String databaseName) {
        super("profiles", connectionString, databaseName);
    }

    public ProfileEntity GetProfileById(String nameProfile){
        List<ProfileEntity> profile = new ArrayList<>();
        CodecRegistry registry = CodecRegistries.fromCodecs(new ProfileEntityCodec());
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                    registry,
                    MongoClientSettings.getDefaultCodecRegistry());

            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<ProfileEntity> collection = database.getCollection(COLLECTION, ProfileEntity.class).withCodecRegistry(codecRegistry);

            //collection.find().into(profile);
            var toto = collection.find().first();
            return toto;
            // collection.find(eq("profilName", nameProfile)).into(profile);
            /*if (doc != null) {
                var profileJson = doc.toJson();
                ObjectMapper mapper = new ObjectMapper();
                profile = mapper.readValue(profileJson, ProfileEntity.class);
            } else {
                System.out.println("No matching documents found.");
            }*/
        }
        // return profile.get(0);
    }

}
