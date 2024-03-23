package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.entities.City;


/**
 * Data Transfer Object (DTO) for Location requests.
 * This class represents the data sent when a user is trying to add new Location or update an existing Location.
 *
 * @author Mohamed Ossalhe
 */

public record LocationRequest(
        City city,
        String address,
        Double latitude,
        Double longitude
) implements GenericRequest {
}
