package fr.iut.AirDB.repository.mappers.profile_mappers;

import fr.iut.AirDB.entity.ProfileEntity;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ProfileEntityCodec implements Codec<ProfileEntity> {
    @Override
    public ProfileEntity decode(BsonReader bsonReader, DecoderContext decoderContext) {
        ProfileEntity profileEntity = new ProfileEntity();
        bsonReader.readStartDocument();
        while (bsonReader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String fieldName = bsonReader.readName();
            switch (fieldName) {
                case "_id" :
                    profileEntity.id = bsonReader.readObjectId();
                case "profileName":
                    profileEntity.profileName = bsonReader.readString();
                case "profilePicture":
                    profileEntity.profileName = bsonReader.readString();
                case "location":
                    profileEntity.profileName = bsonReader.readString();
                case "description":
                    profileEntity.profileName = bsonReader.readString();
            }
        }
        bsonReader.readEndDocument();
        return profileEntity;
    }

    @Override
    public void encode(BsonWriter bsonWriter, ProfileEntity profileEntity, EncoderContext encoderContext) {

    }

    @Override
    public Class<ProfileEntity> getEncoderClass() {
        return ProfileEntity.class;
    }
}
