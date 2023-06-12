package fr.iut.AirDB.services.profileservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.services.BaseService;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class ProfileService extends BaseService {

    public ProfileService(String connectionString, String databaseName) {
        super("profile", connectionString, databaseName);
    }

    public Profile GetProfileById(String idProfile){
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);

            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            Document doc = collection.find(eq("_id", idProfile)).first();
            if (doc != null) {

            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

}
