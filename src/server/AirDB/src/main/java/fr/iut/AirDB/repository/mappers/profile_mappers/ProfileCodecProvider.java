package fr.iut.AirDB.repository.mappers.profile_mappers;

import fr.iut.AirDB.entity.ProfileEntity;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class ProfileCodecProvider implements CodecProvider {

    public ProfileCodecProvider(){}

    @Override
    @SuppressWarnings("unchecked")
    public <T> Codec<T> get(Class<T> aClass, CodecRegistry codecRegistry) {
        if (aClass == ProfileEntity.class) {
            return (Codec<T>) new ProfileEntityCodec();
        }
        // return null when not a provider for the requested class
        return null;
    }
}
