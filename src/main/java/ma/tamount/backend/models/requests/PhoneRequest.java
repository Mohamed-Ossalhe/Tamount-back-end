package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.RegionCode;

/**
 * Data Transfer Object (DTO) for Phone requests.
 * This class represents the data sent when a user is trying to register or verifying his number.
 *
 * @author Mohamed Ossalhe
 */
public record PhoneRequest(
        @NotNull(message = "national number is required")
        Integer nationalNumber,
        @NotNull(message = "national number is required")
        String formattedNumber,
        @NotNull(message = "national number is required")
        String nationalFormattedNumber,
        @NotNull(message = "national number is required")
        String internationalFormattedNumber,
        @NotNull(message = "national number is required")
        RegionCode regionCode
) implements GenericRequest {
}
