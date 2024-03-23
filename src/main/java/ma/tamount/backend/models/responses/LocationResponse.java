package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Location;
import ma.tamount.backend.models.entities.City;

/**
 * DTO (Data Transfer Object) representing car-related responses.
 * This class is designed to carry car-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the car. It is used to transfer car data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see Location
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse extends AbstractResponse {
    /**
     * The city associated with this location.
     */
    private City city;

    /**
     * The address of this location.
     */
    private String address;

    /**
     * Latitude of the location.
     */
    private Double latitude;

    /**
     * Longitude of the location.
     */
    private Double longitude;
}
