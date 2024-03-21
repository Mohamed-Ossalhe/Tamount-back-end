package ma.tamount.backend.exceptions;

/**
 * Exception class for situations when no user is authenticated.
 *
 * @author Mohamed Ossalhe
 */
public class NoAuthenticationUserFoundException extends RuntimeException {
    public NoAuthenticationUserFoundException(String message) {
        super(message);
    }
}
