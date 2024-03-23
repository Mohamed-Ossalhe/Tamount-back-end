package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.PreferenceStatus;


/**
 * Data Transfer Object (DTO) for Preferences requests.
 * This class represents the data sent when a user is trying to add or update his Preferences.
 *
 * @author Mohamed Ossalhe
 */
public record PreferencesRequest(
        PreferenceStatus smoking,
        PreferenceStatus music,
        PreferenceStatus pets,
        PreferenceStatus dialog,
        Boolean preferencesSaved,
        RegistrationRequest user
) implements GenericRequest {
}
