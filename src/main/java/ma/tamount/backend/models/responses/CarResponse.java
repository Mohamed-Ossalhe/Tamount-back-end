package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Car;

/**
 * DTO (Data Transfer Object) representing car-related responses.
 * This class is designed to carry car-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the car. It is used to transfer car data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see Car
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarResponse extends AbstractResponse {
    /**
     * Represents the model of the vehicle.
     */
    private String model;

    /**
     * Represents the make of the vehicle.
     */
    private String make;

    /**
     * Represents the color of the vehicle.
     */
    private String color;

    /**
     * Represents the comfort level of the vehicle.
     */
    private String comfort;

    /**
     * Represents the category of the vehicle.
     */
    private String category;

    /**
     * Represents the license plate of the vehicle.
     */
    private String licensePlate;

    /**
     * Represents the registration year of the vehicle.
     */
    private Integer registrationYear;

    /**
     * Represents the user who owns the vehicle.
     */
    private UserResponse user;
}
