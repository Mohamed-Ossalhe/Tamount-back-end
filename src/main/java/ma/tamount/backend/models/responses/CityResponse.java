package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.City;
import ma.tamount.backend.models.enums.RegionCode;

/**
 * DTO (Data Transfer Object) representing city-related responses.
 * This class is designed to carry city-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the city. It is used to transfer city data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see City
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityResponse extends AbstractResponse {
    /**
     * Represents the name of the city. This field cannot be null.
     */
    private String name;

    /**
     * Represents the city's country code which the city belongs to. This field cannot be null.
     */
    private RegionCode country;
}
