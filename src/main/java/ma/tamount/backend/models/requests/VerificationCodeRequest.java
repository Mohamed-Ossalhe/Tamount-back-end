package ma.tamount.backend.models.requests;

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
        Integer code,
        Timestamp expirationTime,
        VerificationCodeType type,
        RegistrationRequest user
) implements GenericRequest {
}
