package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.BookingStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Represents a booking made by a user for a specific ride.
 * Each booking contains information about the user who made the booking,
 * the ride being booked, the status of the booking, and optionally,
 * a reason for cancellation if the booking is canceled.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends AbstractEntity {

    /**
     * The status of this booking.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    /**
     * The reason for cancellation if this booking is canceled.
     * This field will be null if the booking is not canceled.
     */
    private String cancellationReason;

    /**
     * The user who made this booking.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    /**
     * The ride that is being booked.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ride ride;

    /**
     * The payment history associated with the booking.
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "booking")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PaymentHistory paymentHistory;
}
