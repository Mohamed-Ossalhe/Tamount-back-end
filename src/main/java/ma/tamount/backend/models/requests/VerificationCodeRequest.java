package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.NotNull;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.VerificationCodeType;

import java.sql.Timestamp;

/**
 * Data Transfer Object (DTO) for Verification code requests.
 * This class represents the data sent when a user is trying to verify his account.
 *
 * @author Mohamed Ossalhe
 */
public record VerificationCodeRequest(
        @NotNull(message = "code is required")
        Integer code,
        @NotNull(message = "expiration is required")
        Timestamp expirationTime,
        @NotNull(message = "type is required")
        VerificationCodeType type,
        @NotNull(message = "user is required")
        RegistrationRequest user
) implements GenericRequest {
}
