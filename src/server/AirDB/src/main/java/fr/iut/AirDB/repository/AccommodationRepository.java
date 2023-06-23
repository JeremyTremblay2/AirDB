package fr.iut.AirDB.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import fr.iut.AirDB.entity.AccommodationEntity;
import fr.iut.AirDB.modele.HousingCategory;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.repository.codecs.accommodations.AccommodationCodec;
import fr.iut.AirDB.repository.codecs.accommodations.AccommodationCodecProvider;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccommodationRepository extends AirDBRepository {
    private final MongoCollection<AccommodationEntity> collection;

    public AccommodationRepository(String collection, String connectionString, String databaseName) {
        super(collection, connectionString, databaseName);
        CodecRegistry codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        AccommodationCodecProvider codecProvider = new AccommodationCodecProvider();
        CodecRegistry customCodecRegistry = CodecRegistries.fromRegistries(codecRegistry, CodecRegistries.fromProviders(codecProvider));
        this.collection = database.getCollection("accommodations", AccommodationEntity.class).withCodecRegistry(customCodecRegistry);
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

    public void addAccommodation(Accommodation accommodation) {

    }

    public AccommodationEntity findById(String id) {
        Document query = new Document("_id", new ObjectId(id));
        Document document = collection.find(query).first();
        if (document != null) {
            new AccommodationCodec().
        }
        return null;
    }

//    private static HousingCategory[] mapHousingCategoriesToEntities(List<HousingCategory> categories) {
//        return categories.stream()
//                .map(category -> HousingCategory.valueOf(category.name()))
//                .toArray(HousingCategory[]::new);
//    }

//    private static List<HousingCategory> mapHousingCategoryEntitiesToCategories(HousingCategory[] entities) {
//        return Arrays.stream(entities)
//                .map(entity -> HousingCategory.valueOf(entity.name()))
//                .collect(Collectors.toList());
//    }
}
