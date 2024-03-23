package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Booking;
import ma.tamount.backend.models.entities.PaymentHistory;
import ma.tamount.backend.models.enums.BookingStatus;

/**
 * DTO (Data Transfer Object) representing booking-related responses.
 * This class is designed to carry booking-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the booking. It is used to transfer booking data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see Booking
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponse extends AbstractResponse {
    /**
     * The status of this booking.
     */
    private BookingStatus bookingStatus;

    /**
     * The reason for cancellation if this booking is canceled.
     * This field will be null if the booking is not canceled.
     */
    private String cancellationReason;

    /**
     * The user who made this booking.
     */
    private UserResponse user;

    /**
     * The ride that is being booked.
     */
    private RideResponse ride;

    /**
     * The payment history associated with the booking.
     */
    private PaymentHistory paymentHistory;
}
