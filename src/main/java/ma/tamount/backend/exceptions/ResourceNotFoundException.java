package ma.tamount.backend.exceptions;

/**
 * Exception class for situations where an attempt to retrieve a resource fails.
 *
 * @author Mohamed Ossalhe
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
