package fr.iut.AirDB.repository.codecs;

import fr.iut.AirDB.entity.AccommodationEntity;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class AccommodationCodecProvider implements CodecProvider {
    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (clazz.equals(AccommodationEntity.class)) {
            return (Codec<T>) new AccommodationCodec();
        }
        return null;
    }
}
