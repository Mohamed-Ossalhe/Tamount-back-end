package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
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
        @NotNull(message = "amount is required")
        double amount,
        @NotNull(message = "payment method is required")
        PaymentMethod paymentMethod,
        String transaction,
        @NotNull(message = "status is required")
        PaymentStatus status,
        String description,
        @NotNull(message = "currency is required")
        Currency currency,
        String receiptUrl,
        @NotNull(message = "booking is required")
        BookingRequest booking
) implements GenericRequest {
}
