package fr.iut.AirDB.converters;

import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.modele.Profile;
import fr.iut.AirDB.repository.entity.ProfileEntity;

import java.util.ArrayList;
import java.util.List;

public class ProfileModelDTOConverter {

    public static Profile dtoToModel(ProfileDTO profile){
        return new Profile(profile.getId(), new ArrayList<Accommodation>(), profile.getProfileName(), profile.getHostingSince(), profile.getDateOfBirth(), profile.getProfilePicture(), profile.getLocation(), profile.getDescription());
    }

    public static ProfileDTO modelToDTO(Profile profile){
        return new ProfileDTO(profile.getId(), new ArrayList<Accommodation>(), profile.getProfileName(), profile.getHostingSince(), profile.getDateOfBirth(), profile.getProfilePicture(), profile.getLocation(), profile.getDescription());
    }

    public static List<Profile> dtosToModel(List<ProfileDTO> profiles){
        var pList = new ArrayList<Profile>();
        for(var profile : profiles){
            pList.add(dtoToModel(profile));
        }
        return pList;
    }

    public static List<ProfileDTO> modelsToDTOs(List<Profile> profiles){
        var pList = new ArrayList<ProfileDTO>();
        for(var profile : profiles){
            pList.add(modelToDTO(profile));
        }
        return pList;
    }
}
