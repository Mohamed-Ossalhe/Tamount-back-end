package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.entities.Car;
import ma.tamount.backend.models.entities.Location;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.enums.ApprovalMode;

import java.sql.Timestamp;

/**
 * Data Transfer Object (DTO) for Ride requests.
 * This class represents the data sent when a user is trying to create or update a ride.
 *
 * @author Mohamed Ossalhe
 */
public record RideRequest(
        Location departure,
        Location arrival,
        Timestamp departureTime,
        ApprovalMode approvalMode,
        boolean isComfort,
        boolean womenOnly,
        Integer seats,
        Integer price,
        String routeId,
        User user,
        Car vehicle
) implements GenericRequest {
}
