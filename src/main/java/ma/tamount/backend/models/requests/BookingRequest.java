package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.BookingStatus;

/**
 * Data Transfer Object (DTO) for Booking requests.
 * This class represents the data sent when a user is trying to book new booking or update an existing booking.
 *
 * @author Mohamed Ossalhe
 */
public record BookingRequest(
        @NotNull(message = "booking status is required")
        BookingStatus bookingStatus,
        String cancellationReason,
        @NotNull(message = "user is required")
        RegistrationRequest user,
        @NotNull(message = "ride is required")
        RideRequest ride
) implements GenericRequest {
}
