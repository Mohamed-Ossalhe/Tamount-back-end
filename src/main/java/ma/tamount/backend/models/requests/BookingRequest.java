package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.BookingStatus;

/**
 * Data Transfer Object (DTO) for Booking requests.
 * This class represents the data sent when a user is trying to book new booking or update an existing booking.
 *
 * @author Mohamed Ossalhe
 */
public record BookingRequest(
        BookingStatus bookingStatus,
        String cancellationReason,
        RegistrationRequest user,
        RideRequest ride
) implements GenericRequest {
}
