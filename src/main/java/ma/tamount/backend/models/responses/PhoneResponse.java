package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Phone;
import ma.tamount.backend.models.enums.RegionCode;

/**
 * DTO (Data Transfer Object) representing Phone-related responses.
 * This class is designed to carry phone-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the phone. It is used to transfer phone data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see Phone
 * @author Mohamed Ossalhe
 */@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneResponse extends AbstractResponse {
    /**
     * Represents the national number associated with a phone number.
     * This field cannot be null.
     */
    private Integer nationalNumber;

    /**
     * Represents the formatted number of a phone number.
     * This field cannot be null.
     */
    private String formattedNumber;

    /**
     * Represents the national formatted number of a phone number.
     * This field cannot be null.
     */
    private String nationalFormattedNumber;

    /**
     * Represents the international formatted number of a phone number.
     * This field cannot be null.
     */
    private String internationalFormattedNumber;

    /**
     * Represents the region code associated with a phone number.
     * This field cannot be null.
     */
    private RegionCode regionCode;

    /**
     * Represents the user associated with a phone number.
     * This field is fetched lazily and is subject to cascading deletion.
     */
    private UserResponse user;
}
