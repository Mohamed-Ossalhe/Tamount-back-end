package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.models.enums.Currency;
import ma.tamount.backend.models.enums.PaymentMethod;

public record ChargeRequest(
        String description,
        @NotNull(message = "amount cannot be null")
        @NotEmpty(message = "amount is required")
        Long amount,
        @NotNull(message = "currency cannot be null")
        @NotEmpty(message = "currency is required")
        Currency currency,
        @NotNull(message = "currency cannot be null")
        @NotEmpty(message = "currency is required")
        PaymentMethod paymentMethod,
        @NotNull(message = "token cannot be null")
        @NotEmpty(message = "token is required")
        String token,
        String customer
) {
}
