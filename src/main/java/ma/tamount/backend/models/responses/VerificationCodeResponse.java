package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.VerificationCode;
import ma.tamount.backend.models.enums.VerificationCodeType;

import java.sql.Timestamp;

/**
 * DTO (Data Transfer Object) representing verification-code-related responses.
 * This class is designed to carry verification-code-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the verification code. It is used to transfer verification code data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see VerificationCode
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationCodeResponse extends AbstractResponse {
    /**
     * the verification code
     */
    private Integer code;
    /**
     * the code expiration time
     */
    private Timestamp expirationTime;

    /**
     * the type of the verification code (email/sms)
     */
    private VerificationCodeType type;

    /**
     * the user who used the code
     */
    private UserResponse user;
}
