package fr.iut.AirDB.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import fr.iut.AirDB.entity.GenericEntity;

public abstract class AirDBRepository {
    protected final MongoDatabase database;
    protected final String collection;
    protected String connectionString;
    protected String databaseName;

    public AirDBRepository(String collection, String connectionString, String databaseName) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("The given parameter collection cannot be null or empty");
        }
        if (connectionString == null || connectionString.isEmpty()) {
            throw new IllegalArgumentException("The given parameter connectionString cannot be null or empty");
        }
        if (databaseName == null || databaseName.isEmpty()) {
            throw new IllegalArgumentException("The given parameter databaseName cannot be null or empty");
        }
        this.collection = collection;
        this.connectionString = connectionString;
        this.databaseName = databaseName;
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            database = mongoClient.getDatabase("local");
        }
    }
}
