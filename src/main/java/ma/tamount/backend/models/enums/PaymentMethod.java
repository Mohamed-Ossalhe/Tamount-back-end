package ma.tamount.backend.models.enums;

/**
 * The PaymentMethod enum represents different methods of payment.
 * It provides a set of predefined constants for common payment methods.
 *
 * @author Mohamed Ossalhe
 */
public enum PaymentMethod {
    /**
     * Represents payment via a credit card.
     */
    CREDIT_CARD,

    /**
     * Represents payment via a debit card.
     */
    DEBIT_CARD,

    /**
     * Represents payment via bank transfer.
     */
    BANK_TRANSFER,

    /**
     * Represents payment via PayPal.
     */
    PAYPAL,

    /**
     * Represents payment in cash.
     */
    CASH
}

