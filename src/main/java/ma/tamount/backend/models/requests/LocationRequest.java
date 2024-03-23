package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;


/**
 * Data Transfer Object (DTO) for Location requests.
 * This class represents the data sent when a user is trying to add new Location or update an existing Location.
 *
 * @author Mohamed Ossalhe
 */

public record LocationRequest(
        @NotNull(message = "city is required")
        CityRequest city,
        @NotNull(message = "address is required")
        String address,
        Double latitude,
        Double longitude
) implements GenericRequest {
}
