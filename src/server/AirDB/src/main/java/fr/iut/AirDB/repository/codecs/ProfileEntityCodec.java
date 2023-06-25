package fr.iut.AirDB.repository.codecs;

import fr.iut.AirDB.repository.entity.ProfileEntity;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProfileEntityCodec implements Codec<ProfileEntity> {
    @Override
    public ProfileEntity decode(BsonReader bsonReader, DecoderContext decoderContext) {
        ProfileEntity profileEntity = new ProfileEntity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        bsonReader.readStartDocument();
        try {
            while (bsonReader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                String fieldName = bsonReader.readName();
                switch (fieldName) {
                    case "_id" :
                        profileEntity.id = bsonReader.readString();
                        break;
                    case "housingIds":
                        bsonReader.readStartArray();
                        List<String> list = new ArrayList();
                        while (bsonReader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                            list.add(bsonReader.readString());
                        }
                        profileEntity.housingIds = list;
                        bsonReader.readEndArray();
                        break;
                    case "profilName":
                        profileEntity.profileName = bsonReader.readString();
                        break;
                    case "profilePicture":
                        profileEntity.profilePicture = bsonReader.readString();
                        break;
                    case "location":
                        profileEntity.location = bsonReader.readString();
                        break;
                    case "description":
                        profileEntity.description = bsonReader.readString();
                        break;
                    case "hostingSince":
                        var date = bsonReader.readString();
                        date = date.split(" ")[0].replace("T", " ");
                        profileEntity.hostingSince = LocalDate.parse(date, formatter);
                        break;
                    case "dateOfBirth":
                        var d = bsonReader.readString();
                        d = d.split(" ")[0].replace("T",  " ");
                        profileEntity.dateOfBirth = LocalDate.parse(d, formatter);
                        break;
                    case "rating":
                        profileEntity.rating = bsonReader.readDouble();
                        break;
                    case "numberOfReviews":
                        profileEntity.numberOfReviews = bsonReader.readInt32();
                        break;
                }
            }
            bsonReader.readEndDocument();
            return profileEntity;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void encode(BsonWriter bsonWriter, ProfileEntity profileEntity, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeName("_id");
        bsonWriter.writeString(profileEntity.id);
        bsonWriter.writeName("housingIds");
        bsonWriter.writeStartArray();
        for(var housingId : profileEntity.housingIds){
            bsonWriter.writeString(housingId);
        }
        bsonWriter.writeEndArray();
        bsonWriter.writeName("profilName");
        bsonWriter.writeString(profileEntity.profileName);
        bsonWriter.writeName("profilePicture");
        bsonWriter.writeString(profileEntity.profilePicture);
        bsonWriter.writeName("location");
        bsonWriter.writeString(profileEntity.location);
        bsonWriter.writeName("description");
        bsonWriter.writeString(profileEntity.description);
        bsonWriter.writeName("hostingSince");
        bsonWriter.writeString(profileEntity.hostingSince.toString());
        bsonWriter.writeName("dateOfBirth");
        bsonWriter.writeString(profileEntity.dateOfBirth.toString());
        bsonWriter.writeName("rating");
        bsonWriter.writeDouble(profileEntity.rating);
        bsonWriter.writeName("numberOfReviews");
        bsonWriter.writeInt32(profileEntity.numberOfReviews);
        bsonWriter.writeEndDocument();
    }

    @Override
    public Class<ProfileEntity> getEncoderClass() {
        return ProfileEntity.class;
    }
}
