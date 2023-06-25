package fr.iut.AirDB.converters;

import fr.iut.AirDB.repository.entity.ProfileEntity;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.modele.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileModelEntityConverter {

    public static Profile entityToModel(ProfileEntity profile){
        return new Profile(profile.id, new ArrayList<Accommodation>(), profile.profileName, profile.hostingSince, profile.dateOfBirth, profile.profilePicture, profile.location, profile.description);
    }

    public static ProfileEntity modelToEntity(Profile profile){
        ProfileEntity p = new ProfileEntity();
        p.id = profile.getId();
        p.profileName = profile.getProfileName();
        p.hostingSince = profile.getHostingSince();
        p.dateOfBirth = profile.getDateOfBirth();
        p.profilePicture = profile.getProfilePicture();
        p.location = profile.getLocation();
        p.description = profile.getDescription();
        p.rating = profile.getRating();
        p.numberOfReviews = profile.getNumberOfReviews();
        var housingsId = new ArrayList<String>();
        for (var housing : profile.getHousing()){
            housingsId.add(housing.getId().toString());
        }
        p.housingIds = housingsId;
        return p;
    }

    public static List<Profile> entitiesToModel(List<ProfileEntity> profiles){
        var pList = new ArrayList<Profile>();
        for(var profile : profiles){
            pList.add(entityToModel(profile));
        }
        return pList;
    }

    public static List<ProfileEntity> modelsToEntities(List<Profile> profiles){
        var pList = new ArrayList<ProfileEntity>();
        for(var profile : profiles){
            pList.add(modelToEntity(profile));
        }
        return pList;
    }
}
