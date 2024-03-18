package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO class representing the response for authentication.
 * Contains access and refresh tokens.
 *
 * @author Mohamed Ossalhe
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {
    /**
     * Access token for authentication.
     */
    @NotBlank(message = "Access token is required")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * Refresh token for token refreshing.
     */
    @NotBlank(message = "Refresh token is required")
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * the user's username.
     */
    @NotBlank(message = "Username is required")
    @JsonProperty("username")
    public String username;

    /**
     * the user's email
     */
    @NotBlank(message = "Email is required")
    @JsonProperty("email")
    public String email;

    /**
     * the user's role
     */
    @NotBlank(message = "Role is required")
    @JsonProperty("role")
    public String role;
}
