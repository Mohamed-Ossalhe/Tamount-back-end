package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.responses.UserResponse;

/**
 * Data Transfer Object (DTO) for Car requests.
 * This class represents the data sent when a user is trying to add new car or update an existing car.
 *
 * @author Mohamed Ossalhe
 */

public record CarRequest(
        @NotNull(message = "model is required")
        String model,
        @NotNull(message = "maker is required")
        String make,
        @NotNull(message = "color is required")
        String color,
        @NotNull(message = "comfort is required")
        String comfort,
        @NotNull(message = "category is required")
        String category,
        @NotNull(message = "license plate is required")
        String licensePlate,
        @NotNull(message = "registration year is required")
        Integer registrationYear,
        @NotNull(message = "user is required")
        UserResponse user
) implements GenericRequest {
}
