package ma.tamount.backend.services;

import ma.tamount.backend.models.responses.UserResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

/**
 * Service interface for managing User entity.
 * @author Mohamed Ossalhe
 */
public interface UserService {
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
