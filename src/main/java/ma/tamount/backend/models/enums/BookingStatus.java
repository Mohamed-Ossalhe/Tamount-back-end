package ma.tamount.backend.models.enums;

/**
 * Enumeration representing the status of a booking.
 * <p>
 * Possible values are:
 * <ul>
 * <li>{@code CONFIRMED} - The booking has been confirmed.</li>
 * <li>{@code CANCELLED} - The booking has been cancelled.</li>
 * <li>{@code PENDING} - The booking is pending confirmation.</li>
 * </ul>
 *
 * @author Mohamed Ossalhe
 */
public enum BookingStatus {
    CONFIRMED,
    CANCELLED,
    PENDING
}