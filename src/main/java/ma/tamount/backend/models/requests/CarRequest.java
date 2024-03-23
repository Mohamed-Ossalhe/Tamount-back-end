package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.responses.UserResponse;

import java.time.Year;

/**
 * Data Transfer Object (DTO) for Car requests.
 * This class represents the data sent when a user is trying to add new car or update an existing car.
 *
 * @author Mohamed Ossalhe
 */

public record CarRequest(
        String model,
        String make,
        String color,
        String comfort,
        String category,
        String licensePlate,
        Year registrationYear,
        UserResponse user
) implements GenericRequest {
}
