package ma.tamount.backend.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.PaymentMethod;
import ma.tamount.backend.models.enums.PaymentStatus;

/**
 * Represents the payment history for a booking.
 * This class extends AbstractEntity to inherit common entity properties.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "payment_history")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistory extends AbstractEntity {

    /**
     * The amount of the payment.
     */
    private double amount;

    /**
     * The payment method used for this payment.
     */
    private PaymentMethod paymentMethod;

    /**
     * The transaction ID associated with this payment.
     */
    private String transaction;

    /**
     * The status of the payment.
     */
    private PaymentStatus status;

    /**
     * A description of the payment.
     */
    private String description;

    /**
     * The currency of the payment.
     */
    private String currency;

    /**
     * The URL to the receipt for this payment.
     */
    private String receiptUrl;

    /**
     * The booking associated with this payment.
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Booking booking;
}
