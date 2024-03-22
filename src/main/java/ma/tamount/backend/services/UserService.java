package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.RegistrationRequest;
import ma.tamount.backend.models.responses.UserResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

import java.util.UUID;

/**
 * Service interface for managing User entity.
 * @author Mohamed Ossalhe
 */
public interface UserService extends GenericService<UUID, RegistrationRequest, UserResponse> {
    /**
     * Retrieves the currently authenticated user.
     * <p>
     * This method fetches the current user's details from the Spring Security context.
     * It performs checks to ensure that there is an authenticated user and that the user
     * is not an instance of {@link AnonymousAuthenticationToken}.
     * </p>
     */
    UserResponse getAuthenticatedUser();
}
