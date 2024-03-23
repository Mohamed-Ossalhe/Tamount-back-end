package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.RegionCode;

/**
 * Data Transfer Object (DTO) for City requests.
 * This class represents the data sent when a user is trying to add new City or update an existing City.
 *
 * @author Mohamed Ossalhe
 */

public record CityRequest(
        String name,
        RegionCode country
) implements GenericRequest {
}
