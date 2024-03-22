package ma.tamount.backend.models.enums;

/**
 * Enum representing the status of a payment transaction.
 * This enum includes the possible states a payment can be in: PENDING, SUCCESS, FAILED, and REFUNDED.
 *
 * @author Mohamed Ossalhe
 */
public enum PaymentStatus {
    /**
     * The payment is pending.
     */
    PENDING,

    /**
     * The payment was successful.
     */
    SUCCESS,

    /**
     * The payment failed.
     */
    FAILED,

    /**
     * The payment was refunded.
     */
    REFUNDED
}

