package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Ride;
import ma.tamount.backend.models.enums.ApprovalMode;

import java.sql.Timestamp;

/**
 * DTO (Data Transfer Object) representing ride-related responses.
 * This class is designed to carry ride-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the ride. It is used to transfer ride data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see Ride
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RideResponse extends AbstractResponse {
    /**
     * The departure location of the ride.
     */
    private LocationResponse departure;

    /**
     * The arrival location of the ride.
     */
    private LocationResponse arrival;

    /**
     * The departure time of the ride.
     */
    private Timestamp departureTime;

    /**
     * The approval mode of the ride.
     */
    private ApprovalMode approvalMode;

    /**
     * Indicates whether the ride offers comfort amenities.
     */
    private boolean isComfort;

    /**
     * Indicates whether the ride is cancelled or not.
     */
    private boolean isCancelled;

    /**
     * Indicates whether the ride is for women only.
     */
    private boolean womenOnly;

    /**
     * The number of available seats in the ride.
     */
    private Integer seats;

    /**
     * The price of the trip.
     */
    private Integer price;

    /**
     * The identifier of the route associated with the ride.
     */
    private String routeId;

    /**
     * The user associated with the ride.
     */
    private UserResponse user;

    /**
     * The vehicle associated with the ride.
     */
    private CarResponse vehicle;
}
