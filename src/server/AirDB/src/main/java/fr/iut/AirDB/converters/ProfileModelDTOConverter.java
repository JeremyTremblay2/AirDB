package fr.iut.AirDB.converters;

import fr.iut.AirDB.dto.ProfileDTO;
import fr.iut.AirDB.modele.Accommodation;
import fr.iut.AirDB.modele.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProfileModelDTOConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Profile dtoToModel(ProfileDTO profile){
        var hostingSince = profile.getHostingSince().split(" ")[0].replace("T", " ").split(" ")[0];
        var dateOfBirth = profile.getDateOfBirth().split(" ")[0].replace("T", " ").split(" ")[0];
        return new Profile(profile.get_id(), new ArrayList<Accommodation>(), profile.getProfilName(), LocalDate.parse(hostingSince, formatter), LocalDate.parse(dateOfBirth, formatter), profile.getProfilePicture(), profile.getLocation(), profile.getDescription());
    }

    public static ProfileDTO modelToDTO(Profile profile){
        return new ProfileDTO(profile.getId(), new ArrayList<Accommodation>(), profile.getProfileName(), profile.getHostingSince().toString(), profile.getDateOfBirth().toString(), profile.getProfilePicture(), profile.getLocation(), profile.getDescription());
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
