package fr.iut.AirDB.dto.embedded;

public class ProfileEmbeddedDTO {
    private String profileId;
    private String profileName;
    private String profilePicture;

    public ProfileEmbeddedDTO() {
        this("", "", "");
    }

    public ProfileEmbeddedDTO(String profileId, String profileName, String profilePicture) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profilePicture = profilePicture;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
