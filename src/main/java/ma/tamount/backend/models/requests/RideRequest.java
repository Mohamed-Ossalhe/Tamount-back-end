package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.entities.Location;
import ma.tamount.backend.models.enums.ApprovalMode;

import java.sql.Timestamp;

/**
 * Data Transfer Object (DTO) for Ride requests.
 * This class represents the data sent when a user is trying to create or update a ride.
 *
 * @author Mohamed Ossalhe
 */
public record RideRequest(
        @NotNull(message = "departure is required")
        Location departure,
        @NotNull(message = "arrival is required")
        Location arrival,
        @NotNull(message = "departure time is required")
        Timestamp departureTime,
        @NotNull(message = "approval mode is required")
        ApprovalMode approvalMode,
        @NotNull(message = "comfort is required")
        boolean isComfort,
        @NotNull(message = "women only is required")
        boolean womenOnly,
        @NotNull(message = "seats is required")
        Integer seats,
        @NotNull(message = "price is required")
        Integer price,
        @NotNull(message = "route id is required")
        String routeId,
        @NotNull(message = "user is required")
        RegistrationRequest user,
        @NotNull(message = "vehicle is required")
        CarRequest vehicle
) implements GenericRequest {
}
