package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.ApprovalMode;
import ma.tamount.backend.models.responses.CarResponse;
import ma.tamount.backend.models.responses.LocationResponse;
import ma.tamount.backend.models.responses.UserResponse;

import java.sql.Timestamp;

/**
 * Data Transfer Object (DTO) for Ride requests.
 * This class represents the data sent when a user is trying to create or update a ride.
 *
 * @author Mohamed Ossalhe
 */
public record RideRequest(
        @NotNull(message = "departure is required")
        LocationResponse departure,
        @NotNull(message = "arrival is required")
        LocationResponse arrival,
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
        UserResponse user,
        @NotNull(message = "vehicle is required")
        CarResponse vehicle
) implements GenericRequest {
}
