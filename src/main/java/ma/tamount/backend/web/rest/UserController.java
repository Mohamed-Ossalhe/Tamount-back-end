package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.RegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.tamount.backend.models.responses.UserResponse;
import ma.tamount.backend.services.UserService;

import java.util.UUID;

/**
 * Controller class handling user-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of users (managers, job-seekers, and agents).
 * It utilizes the {@link UserService} to fetch user data and returns the results in the form of {@link UserResponse}.
 * </p>
 *
 * @version 1.0
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController extends AbstractController<UUID, RegistrationRequest, UserResponse, UserService> {

    private final UserService service;

    /**
     * Retrieves the currently authenticated user.
     *
     * @return ResponseEntity containing the current user's details.
     */
    @GetMapping("/authenticated-user")
    public ResponseEntity<UserResponse> getAuthenticatedUser() {
        return new ResponseEntity<>(service.getAuthenticatedUser(), HttpStatus.OK);
    }
}
