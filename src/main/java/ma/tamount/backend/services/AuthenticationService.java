package ma.tamount.backend.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.tamount.backend.models.enums.Role;
import ma.tamount.backend.models.requests.AuthenticationRequest;
import ma.tamount.backend.models.requests.RegistrationRequest;
import ma.tamount.backend.models.responses.AuthenticationResponse;

import java.io.IOException;

/**
 * Interface for user authentication.
 *
 * @author Mohamed Ossalhe
 */
public interface AuthenticationService {
    /**
     * Registers a new user and generates access and refresh tokens.
     *
     * @param request Registration request containing user details
     * @return AuthenticationResponse containing access and refresh tokens
     */
    AuthenticationResponse register(RegistrationRequest request);

    /**
     * Registers an admin user and generates access and refresh tokens.
     *
     * @param request Registration request containing admin user details
     * @return AuthenticationResponse containing access and refresh tokens
     */
    AuthenticationResponse registerAdmin(RegistrationRequest request);

    /**
     * creates a new user and generates access and refresh tokens.
     *
     * @param request Registration request containing user details
     * @param role user role
     * @return AuthenticationResponse containing access and refresh tokens
     */
    AuthenticationResponse createNewUser(RegistrationRequest request, Role role);

    /**
     * Authenticates a user and generates new access and refresh tokens.
     *
     * @param request Authentication request containing user credentials
     * @return AuthenticationResponse containing new access and refresh tokens
     */
    AuthenticationResponse authenticate(AuthenticationRequest request);

    /**
     * Refreshes the access token using a valid refresh token.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse for writing the new tokens
     * @throws IOException if an error occurs during response writing
     */
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * Checks if a token is valid.
     *
     * @param token Token to check
     * @return true if the token is valid, false otherwise
     */
    Boolean checkToken(String token);
}