package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Preferences;
import ma.tamount.backend.models.enums.PreferenceStatus;

/**
 * DTO (Data Transfer Object) representing Preferences-related responses.
 * This class is designed to carry Preferences-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the Preferences. It is used to transfer Preferences data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see Preferences
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferencesResponse extends AbstractResponse {
    /**
     * Represents the preference status for smoking.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    private PreferenceStatus smoking;

    /**
     * Represents the preference status for music.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    private PreferenceStatus music;

    /**
     * Represents the preference status for pets.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    private PreferenceStatus pets;

    /**
     * Represents the preference status for dialog.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    private PreferenceStatus dialog;

    /**
     * Indicates whether the preferences are saved or not.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    private Boolean preferencesSaved;

    /**
     * Represents the user associated with these preferences.
     * This field is mapped as a lazy-loaded one-to-one relationship with the user table.
     * Deletion of associated user records triggers a cascade delete action.
     */
    private UserResponse user;
}
