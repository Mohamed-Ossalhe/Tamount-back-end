package ma.tamount.backend.exceptions;

/**
 * Exception class for situations where an attempt to create a resource fails.
 *
 * @author Mohamed Ossalhe
 */
public class ResourceNotCreatedException extends RuntimeException {
    public ResourceNotCreatedException(String message) {
        super(message);
    }
}
