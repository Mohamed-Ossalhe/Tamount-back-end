package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.Currency;
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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    /**
     * The transaction ID associated with this payment.
     */
    private String transaction;

    /**
     * The status of the payment.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    /**
     * A description of the payment.
     */
    private String description;

    /**
     * The currency of the payment.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

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
