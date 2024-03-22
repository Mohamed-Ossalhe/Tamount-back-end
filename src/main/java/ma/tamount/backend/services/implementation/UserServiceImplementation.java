package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.exceptions.NoAuthenticationUserFoundException;
import ma.tamount.backend.exceptions.ResourceNotFoundException;
import ma.tamount.backend.mappers.UserMapper;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.requests.RegistrationRequest;
import ma.tamount.backend.models.responses.UserResponse;
import ma.tamount.backend.repositories.UserRepository;
import ma.tamount.backend.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

import java.util.UUID;

/**
 * Service class for managing user-related operations.
 *
 * <p>This service class provides methods for retrieving user data based on various criteria,
 * updating user information, and handling user status changes.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImplementation extends AbstractService<UUID, RegistrationRequest, UserResponse, User, UserRepository, UserMapper> implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    /**
     * Retrieves the currently authenticated user.
     * <p>
     * This method fetches the current user's details from the Spring Security context.
     * It performs checks to ensure that there is an authenticated user and that the user
     * is not an instance of {@link AnonymousAuthenticationToken}.
     * </p>
     */
    @Override
    public UserResponse getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken)
            throw new NoAuthenticationUserFoundException("User not authenticated");

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = repository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapper.toResponse(user);
    }
}
