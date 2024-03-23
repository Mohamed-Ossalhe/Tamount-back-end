package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.PaymentHistory;
import ma.tamount.backend.models.enums.Currency;
import ma.tamount.backend.models.enums.PaymentMethod;
import ma.tamount.backend.models.enums.PaymentStatus;

/**
 * DTO (Data Transfer Object) representing Payment-history-related responses.
 * This class is designed to carry payment-history-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the payment history. It is used to transfer payment history data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see PaymentHistory
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentHistoryResponse extends AbstractResponse {
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
    private Currency currency;

    /**
     * The URL to the receipt for this payment.
     */
    private String receiptUrl;

    /**
     * The booking associated with this payment.
     */
    private BookingResponse booking;
}
