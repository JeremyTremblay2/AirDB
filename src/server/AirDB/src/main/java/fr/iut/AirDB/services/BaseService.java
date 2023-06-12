package fr.iut.AirDB.services;

public class BaseService {

    protected final String COLLECTION;
    protected String connectionString;
    protected String databaseName;

    public BaseService(String collection, String connectionString, String databaseName) {
        if(collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Connection string cannot be null or empty");
        }
        if(connectionString == null || connectionString.isEmpty()) {
            throw new IllegalArgumentException("Connection string cannot be null or empty");
        }
        if(databaseName == null || databaseName.isEmpty()) {
            throw new IllegalArgumentException("Connection string cannot be null or empty");
        }
        this.COLLECTION = collection;
        this.connectionString = connectionString;
        this.databaseName = databaseName;
    }
}
