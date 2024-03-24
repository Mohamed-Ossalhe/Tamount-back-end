package ma.tamount.backend.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.exceptions.NoAuthenticationUserFoundException;
import ma.tamount.backend.exceptions.ResourceNotFoundException;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.enums.Role;
import ma.tamount.backend.models.requests.AuthenticationRequest;
import ma.tamount.backend.models.requests.RegistrationRequest;
import ma.tamount.backend.models.responses.AuthenticationResponse;
import ma.tamount.backend.repositories.UserRepository;
import ma.tamount.backend.security.jwt.JwtService;
import ma.tamount.backend.services.AuthenticationService;
import ma.tamount.backend.utils.Utils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Implementation of the Service class {@link AuthenticationService} for user authentication and token management.
 * This service provides methods to register a new user, authenticate a user, and refresh access tokens.
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final JwtService jwtService;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private static final String USER_NOT_FOUND_MESSAGE_EXCEPTION = "User not found";

    /**
     * Registers a new user and generates access and refresh tokens.
     *
     * @param request Registration request containing user details
     * @return AuthenticationResponse containing access and refresh tokens
     */
    @Override
    public AuthenticationResponse register(RegistrationRequest request) {
        return createNewUser(request, Role.USER);
    }

    /**
     * Registers a new admin and generates access and refresh tokens.
     *
     * @param request Registration request containing job seeker details
     * @return AuthenticationResponse containing access and refresh tokens
     */
    @Override
    public AuthenticationResponse registerAdmin(RegistrationRequest request) {
        return createNewUser(request, Role.ADMIN);
    }

    /**
     * Creates a new user based on the registration request and assigns a specified role.
     * This method involves setting up a new user with the provided details, encoding the password,
     * and saving the user to the database. It then generates JWT access and refresh tokens for the
     * new user and saves these tokens. This process is essential for registering new users and
     * providing them with the necessary tokens to access secured endpoints.
     *
     * @param request The registration request containing the new user's details such as name, email, and password.
     * @param role    The role to be assigned to the new user, which determines the user's permissions and access.
     * @return AuthenticationResponse containing the generated JWT access and refresh tokens.
     */
    @Override
    public AuthenticationResponse createNewUser(RegistrationRequest request, Role role) {
        log.info("Creating a new user with role: {}", role);

        var user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .firstName(request.firstName())
                .lastName(request.lastName())
                .bio(null)
                .birthYear(request.birthDate().getYear())
                .birthDate(request.birthDate())
                .age(Utils.calculateAge(request.birthDate()))
                .gender(request.gender())
                .role(role)
                .lastLogin(Timestamp.from(Instant.now()))
                .picture("https://res.cloudinary.com/dm9amldit/image/upload/v1710715083/default-avatar_jn3ted.svg")
                .build();

        var savedUser = repository.save(user);
        log.info("User with ID {} created successfully.", savedUser.getId());

        var jwtToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        log.info("Access and refresh tokens generated and saved for user with ID: {}", savedUser.getId());

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .username(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().toString())
                .build();
    }

    /**
     * Authenticates a user and generates new access and refresh tokens.
     *
     * @param request Authentication request containing user credentials
     * @return AuthenticationResponse containing new access and refresh tokens
     */
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        } catch (BadCredentialsException ex) {
            log.error("Authentication failed for user: {}", request.email(), ex);
            throw new BadCredentialsException("Invalid credentials");
        } catch (AuthenticationException ex) {
            log.error("Authentication failed for user: {}", request.email(), ex);
            throw new ResourceNotFoundException("Authentication failed");
        }
        var user = repository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_MESSAGE_EXCEPTION));
        var jwtToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        user.setLastLogin(Timestamp.from(Instant.now()));
        repository.save(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .username(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().toString())
                .build();
    }

    /**
     * Refreshes the access token using a valid refresh token.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse for writing the new tokens
     * @throws IOException if an error occurs during response writing
     */
    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_MESSAGE_EXCEPTION));
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateAccessToken(user);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .email(user.getEmail())
                        .username(user.getFirstName() + " " + user.getLastName())
                        .role(user.getRole().toString())
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    /**
     * Checks whether a token is valid.
     *
     * @param token Token to be checked
     * @return True if the token is valid, false otherwise
     */
    @Override
    public Boolean checkToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return false;
        }
        String jwt = token.substring(7);
        var userEmail = jwtService.extractUsername(jwt);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_MESSAGE_EXCEPTION));
            return jwtService.isTokenValid(jwt, user);
        }
        return false;
    }

    @Override
    public User authenticatedUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken)
            throw new NoAuthenticationUserFoundException("User not authenticated");

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return repository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_MESSAGE_EXCEPTION));
    }
}
