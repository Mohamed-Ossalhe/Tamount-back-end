package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ma.tamount.backend.interfaces.GenericRequest;

/**
 * Data Transfer Object (DTO) for authentication requests.
 * This class represents the data sent when a user is trying to authenticate.
 * It includes the user's email and password.
 *
 * @author Mohamed Ossalhe
 */
public record AuthenticationRequest(
        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
        String password
) implements GenericRequest {
}
