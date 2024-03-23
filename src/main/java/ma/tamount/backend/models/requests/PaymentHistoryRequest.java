package ma.tamount.backend.models.requests;

import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.Currency;
import ma.tamount.backend.models.enums.PaymentMethod;
import ma.tamount.backend.models.enums.PaymentStatus;

/**
 * Data Transfer Object (DTO) for Payment History requests.
 * This class represents the data sent when a user is trying to add new Payment History.
 *
 * @author Mohamed Ossalhe
 */
public record PaymentHistoryRequest(
        double amount,
        PaymentMethod paymentMethod,
        String transaction,
        PaymentStatus status,
        String description,
        Currency currency,
        String receiptUrl,
        BookingRequest booking
) implements GenericRequest {
}
