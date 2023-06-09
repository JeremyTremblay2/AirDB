package fr.iut.AirDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.mongodb.client.model.Filters.eq;

@SpringBootApplication
public class AirDbApplication {
	public static void main(String[] args) {
		String uri = "mongodb://localhost:27017";
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase("local");

			MongoCollection<Document> collection = database.getCollection("accomodations");
			Document doc = collection.find(eq("numberOfReviews", 85)).first();
			if (doc != null) {
				System.out.println(doc.toJson());
			} else {
				System.out.println("No matching documents found.");
			}
		}
	}
}